import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class quiz1 {
	public static HashMap <Integer, String> studentV = new HashMap<Integer, String>();
	
	public static void addStudent(Integer id, String name) {  //added to the parent hashMap
		studentV.put(id, name);
	}
	
	public static String getName (Integer id) {
		return studentV.get(id);
	}
	
	public static String[] getUniqueNames() {
		
		Collection<String> valuesN = studentV.values();
		ArrayList <String> names = new ArrayList<String>(valuesN);  //got the names 
		HashSet<String> hset = new HashSet<String>(names);
		String[]uniqueNames = hset.toArray(new String[hset.size()]); //an array containing unique names 
		return uniqueNames;
		
	}
	public static void main (String[]args) {

		addStudent(1, "Kamso");
		addStudent(2, "Kamso");
		addStudent(3, "Teddy");
		addStudent(4, "Paul");
		addStudent(5, "Farzana ");
		System.out.println("\n" + "***name at specific index 1***");
		System.out.println(getName(1));  //specific key 
		//print all the values
		System.out.println("\n" + "***get all the names***");
		Collection<String> valuesN = studentV.values();
		ArrayList <String> names = new ArrayList<String>(valuesN); 
		for(String str : names) {
			System.out.print(str + " ");
		}
		
		System.out.println("\n" + "\n" + "****unique names****");
		for(String str : getUniqueNames()) {
			System.out.println(str);
		}
		
	}
}
