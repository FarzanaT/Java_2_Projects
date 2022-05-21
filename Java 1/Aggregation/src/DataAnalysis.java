import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class DataAnalysis 
{
	// Class data because it is static--there is only one copy of this array--no objects //WHAT?
	public static ArrayList<Store> stores;

	public static void main(String[] args) throws FileNotFoundException
	{
		// Construct the stores ArrayList and get the data from the file
		stores = new ArrayList<Store>(3);
		Store s = new Store("Pet Company", "Data.txt"); // Items for this store were constructed here
		stores.add(s);
		s = new Store("Pet Clever", "Data.txt");
		stores.add(s);
		s = new Store("Pet Friends", "Data.txt");
		stores.add(s);
		
		double[] average = findAveragePrice();
		System.out.println(Arrays.toString(average));
		
		ArrayList<String> haveIt = findItemInStores("Dog Toy");
		System.out.println(haveIt);
		// System.out.println(stores);
	}

	// Class methods are allowed to use class data, but not instance data
	// This class does not have instance data
	private static ArrayList<String> findItemInStores(String item)
	{
		ArrayList<String> result = new ArrayList<String>(stores.size());
		
		for (Store s: stores)
		{
			if (s.getPrice(item) >= 0.0)
			{
				result.add(s.getName());
			}
		}
		return result; // stub
	}
	
	private static double[] findAveragePrice()
	{
		double[] result = new double[stores.size()];
		
		int index = 0;
		for (Store s: stores)
		{
			double avg = s.getAveragePrice();
			result[index] = avg;
			++index;
		}
		return result;
	}
}
