
import java.util.Arrays;
import java.util.StringJoiner;

public class Adjuster extends Presenter{
   
   // make private variables for int: seed, size, numberOfStars
   // make private variable for char: frame symbol
	private int seed;
	private int size;
	private int numberOfStars;
	
	private char frameSymbol;
	//private char symbol;
	
	
	private final static String NAME = "Adjuster"; 
	
	
	// throw an exception WrongValueException if:
	// * the seed is less than zero
	// * the size is less than zero
	
	public Adjuster(int seed, int size, char frameSymbol) throws WrongValueException  {
      // a lot of code goes here
		if (seed < 0) {
			throw new WrongValueException("the seed is less than zero");
		}
		else if (size < 0) {
			throw new WrongValueException("the size is less than zero");
		}
		this.seed = seed;
		this.size = size;
		this.frameSymbol = frameSymbol;
	}
	
	// set bot seed and size to five, and set the frameSymbol to *
	public Adjuster() {
      // your code goes here
		seed = 5;
		size = 5;
		frameSymbol = '*';
	}
	
	// keep these methods to yourself, students will have to implements something on their own
	private int calculateWordSize(int i) {
		Integer n = Integer.valueOf(i);
		String str = n.toString();
		return str.length();
	}
	
	private int calculateFrameLength() {  //ok
		int s = calculateWordSize(seed);
		s += calculateWordSize(size);
		s += 3; // TODO decide on format
		return s;
	}
	
	// Return String[] str
	// str[0] will have the NAME
	// str[1] will create a nice frame around the seed = 5 and size = 5
	// Pay attention that the size of the frame has to reszie to accomodate different 
	// numbers
	// For Example,
	// 
	// *****
   // *5*5*
   // *****
	// 
	// I know, it is really pretty.
	@Override
	public String[] present() {
     // a lot of code goes here
		String str [] = new String [2];
		str [0] = NAME;
		String symb = String.valueOf(frameSymbol);
		String toJoin = "";
		StringJoiner strJ = new StringJoiner (symb, symb, symb);
		toJoin += symb.repeat(calculateFrameLength()) + "\n"; 
		strJ.add(Integer.toString(seed));
		strJ.add(Integer.toString(seed));
		//toJoin += strJ.add(Integer.toString(seed));
		//toJoin += strJ.add(Integer.toString(size)) + "\n";
		toJoin += strJ + "\n";
		toJoin += symb.repeat(calculateFrameLength());
		
		//str[1] =  symb + Integer.toString(seed) + Integer.toBinaryString(size) + symb;
		str[1] = toJoin;
		return str;
	}
	
	
	// Create a string  having the in the first line NAME
	// and in the second line frame similar to the one in this.present()
	// Example:
	//
	// Adjuster
   // --------
   // -100-10-
   // --------
	@Override
	public String toString() { //ok
      String str = "";
     String valueN[] = this.present().clone();
//     for (int i = 0; i<valueN.length; i++) {
//    	 str += valueN[0] + "\n";   //check on extra new line 
//     }
     str = valueN[0] + System.lineSeparator() + valueN[1];
     
      return str;
      
 
	}

   // return the number of starts based on these arrays
   // betweeen 1 and 10 get 1 star
   // between  10 and 20 get 2 stars
   // between 20 and 40 get 3 stars
   // between 40 and 80 get 4 stars
   // from 80 get 5 stars
   // it is inclusive on the lower bound, exclusive on upper bounds except the last
	@Override
	public int getNumberOfStars() {
		int n = calculateFrameLength();
		if (n >= 1 && n < 10) {
			return 1;
		}
		else if (n >= 10 && n < 20) {
			return 2;
		}
		else if (n >= 20 && n < 40) {
			return 3;
		}
		else if(n >= 40 && n < 80) {
			return 4;
		}
		else if (n >= 80) {
			return 5;
		}
		
			 return 5;
	}
}
