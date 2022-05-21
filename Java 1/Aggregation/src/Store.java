import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Store 
{
	// Instance Data
	private String name;
	private ArrayList<Item> inventory;
	
	// Constructors
	public Store(String name, String fileName) throws FileNotFoundException
	{
		this.name = name;
		
		Scanner file = new Scanner(new File(fileName));
		
		int numItems = file.nextInt();
		file.nextLine(); // get ride of the newline character
		
		inventory = new ArrayList<Item>(numItems);
		
		for (int index=0; index < numItems; ++index)
		{
			// Read in each line of the file
			String line = file.nextLine();
			
			int firstComma = line.indexOf(',');
			int lastComma = line.lastIndexOf(',');
			
			String company = line.substring(0, firstComma);
			String item = line.substring(firstComma+2, lastComma);
			String sPrice = line.substring(lastComma + 2);
			double price = Double.parseDouble(sPrice);
			
			if (company.equals(name))
			{
				Item newItem = new Item(item,price);
				inventory.add(newItem);
			}
			
		}
		
		file.close();
	}
	
	// Accessors
	public String getName()
	{
		return name;
	}
	
	public double getPrice(String item)
	{
		for (Item it: inventory)
		{
			String name = it.getName();
			// if it has the same name given by item, the parameter
			if (item.equals(name))
			{
				return it.getPrice();
			}
		}
		return -1.0; // Indicates that the item was not found
	}
	
	public double getAveragePrice()
	{
		double sum = 0.0;
		for (int index=0; index < inventory.size(); ++index)
		{
			Item it = inventory.get(index);
			sum += it.getPrice();
		}
		return sum / inventory.size();
	}
	
	public String toString()
	{
		return "Company name: " + name + " Inventory " + inventory.toString();
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Store store = new Store("Pet Company", "Data.txt");
		
		System.out.println(store);
		
		System.out.println(store.getPrice("Cat Toy"));
		System.out.println(store.getAveragePrice());
	}
}
