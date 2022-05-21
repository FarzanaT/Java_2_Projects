import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Unique {
	private List<String> list;
	// set it as a message for IllegalArgumentException
	private final String ERROR_MESSAGE = "List cannot be empyt";
	
	// you may have throw an exception if the list has no elements
	public Unique(List<String> list) throws IllegalArgumentException{
		// your code goes here
		if(list.size() == 0) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
		//this.list = new List <String>(list);
		else {
//		for(String str : list) {
//			this.list.add(str);
//		}
			this.list = list;
		}
		
	}
	
	public void set(List<String> list) throws IllegalArgumentException{
	   // throw and exception if the list has no elements
	   // your code goes here
		if(list.isEmpty() == true) {
			throw new IllegalArgumentException(ERROR_MESSAGE);
		}
		for (int i = 0; i<list.size(); i++) {
			this.list.set(i, list.get(i)); //setting new elements 
		}
	}
	
	public ArrayList<String> getNonNullValues() {
      // return ArrayList, but only containg String elements that are not null
      // Example
      // if internally we have {null, null, "cat"}
      // return a list with only a "cat"
		ArrayList <String> toReturn = new ArrayList<>();
		for(String str : this.list) {
			if(str != null) {
				toReturn.add(str);
			}
		}
		return toReturn;
	}
	
	public List<String> getSortedValues() {	
	   // return a list that has sorted values
	   // WITH ONE CONDITION: elements that are returned cannot be null
			ArrayList<String> newAL = getNonNullValues(); //getting the non-null list 
			Collections.sort(newAL); //sort the arrayList 
			List<String> listN = new ArrayList<>(newAL); //assign
			return listN;
			
	}
	
	public String[] getUniqueSortedValues() {
	   // return an array  that has sorted UNIQUE values
	   // WITH ONE CONDITION: elements that are returned cannot be null
		ArrayList <String> retrieveV = new ArrayList<>();
		retrieveV.addAll(getSortedValues());
		ArrayList<String> toRet = new ArrayList<String>();
		//check for unique values in the arraylist
		HashSet<String> hset = new HashSet<String>(retrieveV);

				
	String [] newA =  hset.toArray(new String[hset.size()]);

	return newA;
	}
	
	

}
