

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.*;

public class Presenter extends Informer {

	private int number;
	private char frameSymbol;
	private String str;
	private String type;
	private int numberOfStars = 5;

   // Throw an exception when number is less than zero
   // with the text "Number cannot be smaller than zero " and a number value
   // When str is empty or null, set str to "EMPTY"
   // Set the rest of the member variables
   //
	public Presenter(int number, String str, char frameCharacter, String type) throws IllegalArgumentException {
      // your code goes here
		if(number < 0) {
			throw new IllegalArgumentException("Number cannot be smaller than zero");
		}
		if (str == "" || str == null) {
			str = "EMPTY";
		}
		this.number = number;
		this.str = str;
		this.frameSymbol = frameCharacter;
		this.type = type;
	}

	private Presenter() {
		number = 5;
		str = "5";
		frameSymbol = '*';
	}

   // First element of the returned array has the value of this.info
   //   all in the capital letters
   //
   // Second element of the returned array has:
   // this.number and this.str separated by the this.frameSymbol
   // and the line above and below are created using this.frame symbol
   // Example: for the sentence: "This is a sentence" that has number 10
   // ***********************
   // *10*This is a sentence*
   // ***********************
   //
   // ************************
   // *100*This is a sentence*
   // ************************
   
   // The line above and below are equal in number of characters of the line in the middle
   // The last line has "\n" added to it.
	@Override
	public String[] present(String info) {  //ok
      //your code goes here
		
		String [] valueA = new String [2];
		valueA [0] = info.toUpperCase();
		String symb = String.valueOf(frameSymbol);
		StringJoiner str = new StringJoiner(symb, symb, symb);
		String toJoin = "";
		//int a =10;
		Integer n = Integer.valueOf(number);
		String nString = n.toString();
		int toRep = info.length() + nString.length() + 3;
		
		toJoin += symb.repeat(toRep) + "\n";
		str.add(nString);
		str.add(info);
		toJoin += str + "\n";
		toJoin += symb.repeat(toRep) + "\n";
		valueA[1] = toJoin;
		return valueA; 
	}

	// Use present(String info), and use this.type as info
	// Create a string by concatenation of the first element returned by present(String info)
	// followed by a new line character
	// followed by the second element returned by present(String info)
	@Override
	public String toString() {
      // your code goes here
		String str = "";
	    String valueN[] = this.present(str).clone();
	    str = valueN[0] + System.lineSeparator() + valueN[1];
		return str;
	}

	@Override
	public int getNumberOfStars() {  //ok
		// return 3 if number of letter 'a'  present in the string is equal or more than 3
		// return 2 if number of letter 'a'  present in the string is equal to 2
		// return 1 if number of letter 'a'  present in the string is equal to  1
		// return 0 if number of letter 'a'  present in the string is equal to  0
      // your code goes here
		int nA = 0;
		for (int i = 0; i<str.length(); i++) {
			if(str.charAt(i)  == 'a') {
				nA++;
			}
		}
		if(nA >= 3) {
			return 3;
		}
		else if(nA >= 2) {
			return 2;
		}
		else if(nA >= 1) {
			return 1;
		}
		else {
			return nA;
		}

	}
}
