
import java.util.*;

public class Numbers extends Presenter {

	protected int[] values;
	int size;
	private static final String NAME = "Numbers";

   // create value[] using the seed and size
   // use 1000 for the limit
	public Numbers(int seed, int size) {  //ok
		fillRandomly(seed, size, 1000);
	}
	
	// this one is good
	public Numbers() {
		// nothing to implement
	}

	public void setNums(int[] nums) { //ok
		// your code goes here
		if(nums == null) {
			values = new int[1];
			values [0] = 0;
		}
		values = nums.clone();
	}

	public int[] getNums() {  //0k
		// your code goes here
		return values.clone();  //returning the copied array
	}

   // find and return the maximum value in values[]
	public int findMax() {   //ok
      // your code goes here  //maximum number in the values array 
		Arrays.sort(values);
		int temp = 0;
		for (int i = 0; i<values.length-1; ++i) {
			//int temp; 
			if (values[i] > values [i+1]) {
				temp = values[i];
			}
			else {
				temp = values[i+1];
			}
			
		}
		return temp;
		
	}

	// Fill array nums with pseudo-random integers 0 up to "upTo" with a seed value
	public void fillRandomly(int seed, int size, int upTo) {   //ok
//		if (size < 0 || size > values.length) {
//			throw new WrongValueException("");
//		}
		Random rand = new Random(seed); 
      // your code goes here
		this.values = new int[size];
		for (int i = 0; i< size; i++) {
			//int num = rand.nextInt(upTo);
			values[i] = rand.nextInt(upTo);
		}
		
	}

	@Override
	public String[] present() {
		// first element of [] set to NAME
		// second element set to 
		// {1, 2, 3}
		// for values containing [1, 2, 3]
      String[] returnS = new String [this.values.length + 1];
      returnS [0] = NAME;
      for (int i = 1, j=0; i<returnS.length; i++, j++) {
    	  returnS[i] = Integer.toString(values[j]);
      }
      return returnS;
		
      // your code goes here
	}
	
	// For and empty array, return:
	// >Empty
	//
	// for values = {1, 2, 3}, return:
	// >1, 2, 3
	// Note: you don't have to remove and empty space " " after the last element
	//
	@Override
	public String toString() {
		String [] newV = present();
		if (newV == null || (newV.length == 1 && newV[0] == "")) {
			return "Empty";
		}
		String str = "";
		for (int i = 0; i<newV.length-1; i++) {
			str += newV[i] + ", ";
		}
		str += newV[newV.length-1];
//		if (values == null) {
//			return "Empty";
//		}
//		String str = "";
//		for (int i = 0; i<values.length;i++) {
//			str += Integer.toString(values[i]) + " ";
//		}
		
		return ">" + str;
	}

   // if the size of values is zero, return 0
   // if the size of values is less equal to five, return one
   // if the size of values is less equal to ten, return two
   // if the size of values is less equal to 15, return three
   // if the size of values is less equal to twenty, return 4
   // yes, the rest of them gest five stars.
	@Override
	public int getNumberOfStars() {
		if(values.length == 0) {
			return 0;
		}
		else if (values.length <= 5) {
			return 1;
		}
		else if(values.length <= 10) {
			return 2;
		}
		else if(values.length <= 15) {
			return 3;
		}
		else if(values.length <= 20) {
			return 4;
		}
		else {
			return 5;
		}
	}
}
