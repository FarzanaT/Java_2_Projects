package mockExam;

import java.util.Arrays;

public class Reverser extends Presenter{ 
	 static int c [];
//	 public Reverser(int[] arr) {
//		// TODO Auto-generated constructor stub
//	}
	public String info(){
	    String str = "";
	    for (int x: c){
	       str += String.valueOf(x);
	    }
	    return "<" + str + ">";
	 }
		// method to reverse an array and displaying it
		public static int[] reverse(int a[]) throws EmptyArrayException { 
		   
			int[] b = new int[a.length]; //
		//	c = Arrays.copyOf(a, a.length);
		//	int j = n; 
//			if (a.length == 0){
//		    throw new EmptyArrayException();  
//		   }
		   
			for (int i = a.length-1, k = 0; i>= 0 && k<a.length; i--, k++) { // complete for loop definition
				b[k] = a[i];
				// do some coding
			}
			return b;
		} 
		
		
		// info has to return a content for an array {1, 2, 3{ like
		// <1, 2, 3>
		  
		public static void main(String[] args) throws EmptyArrayException 
		{ 
			int [] arr = {10, 20, 30, 40, 50}; 
			Reverser r = new Reverser();
			r.reverse(arr);
			
			System.out.println (Arrays.toString(arr));
		}	
	} 
	   