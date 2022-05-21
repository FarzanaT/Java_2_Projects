
public class Item 
{
	// Instance Data
	private String name;
	private double price;
	
	// Constructors
	// name and price are shadowing the instance data--this means they have same name
	public Item(String name, double price)
	{
		this.name = name;
		this.price = price;
	}
	
	// Accessors
	public String getName()
	{
		return name;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public String toString()
	{
		return name + ": " + price;
	}
	
	
	// This is to test the Item class
	public static void main(String[] args)
	{
		Item item = new Item ("Dog toy", 19.99);
		
		System.out.println(item.getName());
		System.out.println(item.getPrice());
		
		System.out.println(item); // toString is called here automatically by the println method
	}
}
