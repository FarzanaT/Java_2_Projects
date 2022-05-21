import java.util.Arrays;
import java.util.function.BooleanSupplier;

/**
 * Implement each of the 10 methods tested in JUnitTests.java. Study the tests
 * to determine how the methods should work.
 */
public class Java1Review {

	public static void main(String[] args) {
		// If you want to write your own tests, do so here. (Do not modify
		// JUnitTests.java.) To run this method in Eclipse, right-click
		// Java1Review.java in the Package Explorer and select "Run As" >
		// "Java Application" from the context menu.
	}

	public static double divide(double a, double b) {    //access modifiers - private or public //static VS non-static method - doesnt depend on object
		return a/b; 
	}
	
	public static int divide(int a, int b) {    //access modifiers - private or public //static VS non-static method - doesnt depend on object
		return a/b; 
	}

	public static boolean isDivisibleBy7(int i) { //DONE
		if ((i%7) == 0) {
			return true;
		}
		return false; 
	}
	
	
	public static int findMin (int i, int j, int k) { //DONE
		if(i<j && i<k) {
			return i;
		}
		else if(j<i && j<k) {
			return j;
		}
		else {
			return k;
		}
		
	//return 0;
	}

	public static int findMin(int[] array) {   //DONE
		Arrays.sort(array);
		return array[0];  
	}

	public static double average(int[] array) { //DONE
		// TODO Auto-generated method stub
		double total = 0.0;
		for (int i = 0; i<array.length; i++) {
			total += array[i];
		}
		return total/array.length;
	}

	public static void toLowerCase(String[] strings) { 
		// TODO Auto-generated method stub
		for (int i = 0; i<strings.length; i++) {
			strings[i] = strings[i].toLowerCase();
		}
	}
	

	public static void removeDuplicates(int[] array) {
		// TODO Auto-generated method stub
		int temp;
		
		int [] newArray = array.clone();
		for (int i = 0; i < array.length; ++i) {
			temp = array[i];
			 for (int j = i+1; j < newArray.length; ++j) {
				 if (temp == newArray[j]) {
					 array[i] = 0; 
					 array[j] = 0;
					 
				 }
			 }
		}
	}

	public static Object[] toLowerCaseCopy(String[] strings) { //DONE
		String newArray[] = new String [strings.length];
		for (int i =0; i<strings.length; i++) {
			newArray[i] = strings[i].toLowerCase();
		}
		return newArray; 
	}

	public static String main(String string) { //DONE
		// TODO Auto-generated method stub
		return ("Overloaded main method was passed \"" + string + "\".");
	}

}
