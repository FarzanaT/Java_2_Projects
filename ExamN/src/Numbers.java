
import java.util.*;

public class Numbers extends Presenter {

	protected int[] values;
	private static final String NAME = "Numbers";

   // create value[] using the seed and size
   // use 1000 for the limit
	public Numbers(int seed, int size) {
	   // implement
//		for (int i = 0; i< size; i++) {
			values = fillRandomly(seed, size, 1000);
//		}
	
		
	}
	
	// this one is good
	public Numbers() {
		// nothing to implement
	}

	public void setNums(int[] nums) {
		// your code goes here
		values = nums;
	}

	public int[] getNums() {
		return values;
		// your code goes here
	}

   // find and return the maximum value in values[]
	public int findMax() {
      // your code goes here  //maximum number in the values array 
		Arrays.sort(values);
		for (int i = 0; i<values.length-1; ++i) {
			int temp; 
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
	public void fillRandomly(int seed, int size, int upTo) throws WrongValueException {
		if (size < 0 || size > values.length) {
			throw new WrongValueException("");
		}
		Random rand = new Random(seed); // I would use it
      // your code goes here
		
		for (int i = 0; i< size; i++) {
			int num = rand.nextInt(upTo)+1;
			values[i] = num;
		}
		
	}

	@Override
	public String[] present() {
		// first element of [] set to NAME
		// second element set to 
		// {1, 2, 3}
		// for values containing [1, 2, 3]
      
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
      // a lot of code goes here
	}

   // if the size of values is zero, return 0
   // if the size of values is less equal to five, return one
   // if the size of values is less equal to ten, return two
   // if the size of values is less equal to 15, return three
   // if the size of values is less equal to twenty, return 4
   // yes, the rest of them gest five stars.
	@Override
	public int getNumberOfStars() {
      // a lot of code goes here
	}
}
