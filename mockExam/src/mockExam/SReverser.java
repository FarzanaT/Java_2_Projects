package mockExam;


import java.util.Arrays;
//reverse only the part of the array indicated by index (from, to)
//example 
//{1, 2, 3}
//reverse(2,3) would give
//{1, 3, 2}

//throw an excpetion, if bound are negative, or if to > from

public class SReverser extends Reverser{
int [] copyA;
	public SReverser(int[] a) throws EmptyArrayException {
	//code
	super ();
	copyA = Arrays.copyOf(a, a.length);
	}
	
	public int[] reverse(int from, int upTo) throws InvalidBoundsException{
	   // need some code
	   if (from < 0 || upTo > copyA.length-1){
	    throw new InvalidBoundsException();
	   }
	   
	}

}
