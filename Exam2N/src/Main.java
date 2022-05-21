import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


	public static void main(String[] args) {
		
		String[] strs = {"one", "one", "two", "three", null};	
		ArrayList<String> list = new ArrayList<>();
		list.addAll(Arrays.asList(strs));
		
		list.forEach(e -> System.out.println(e));
		System.out.println("---");
		
		for(String str: strs) list.add(str);
		Unique u = new Unique(list);		
		ArrayList<String> ne = u.getNonNullValues();	
		ne.forEach(e -> System.out.println(e));
		System.out.println("---");
		
		String[] x =  u.getUniqueSortedValues();
		for(String str: x)
			System.out.println("us: " + str);
		

	}

}
