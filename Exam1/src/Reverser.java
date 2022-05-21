import java.util.ArrayList;
import java.util.Arrays;

public class Reverser extends Numbers {
   
      //TODO add some code
      //
      // you may have to add more constrctors
	public ArrayList <Integer> List = new ArrayList<>();
	
	public Reverser() {
		values = new int[1];
		values[0] = 0;

	}
      
      public Reverser( int seed, int size) {
         // some code goes here
    	  super(seed, size);
      }
      
   	// TODO
   	// return the ArrayList that has the elements 
   	// that Numbers has in int[] nums,
   	// but in the reversed order
   	public ArrayList<Integer> reverse(){
         // your code goes here	int[] digits = getNums();
   		int[] nArray = getNums();
		Arrays.sort(nArray);

		List = new ArrayList<Integer>(nArray.length);

		for (int i = nArray.length - 1; i >= 0; --i) {
			List.add(nArray[i]);
		}

		return List;

       //  return new ArrayList<Integer>();
	   }
	   
	   // TODO 
	   // find the second biggest value
	   // keep in mind that the biggest value could be include more 
	   // than once
	   public int findSecondBiggest() {
	      // your code goes here
		   int [] nArray = getNums();
		   
		   int max = nArray[0];
		   int sMax = nArray[1];
		   
		   for (int i =0; i< nArray.length; i++) {
			   if (nArray[i] > max) {
				   sMax = max;
				   max = nArray[i];
			   }
			  return sMax;
				   
		   }
		   
		   
	   	   return 0;
	   }	 
}
