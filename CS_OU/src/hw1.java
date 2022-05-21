import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class hw1 {
	  public static List<Integer> counts(List<Integer> teamA, List<Integer> teamB) {
		    // Write your code here
		        List <Integer> toReturn = new ArrayList<Integer>();
		        int count = 0;
		        for(int i : teamB){
		            for(int j : teamA){
		                if(j <= i){
		                   count++;
		                }
		            }
		            toReturn.add(count);
		            count = 0;
		                }
		        
		        return toReturn;
		    }
/**
 * 
 *   public static List<Integer> counts(List<Integer> teamA, List<Integer> teamB) {
    // Write your code here
        List <Integer> toReturn = new ArrayList<Integer>();
        int count = 0;
        for(int i = 0; i<teamB.size(); i++){
            for(int  j = 0; j<teamA.size(); j++){
                if(teamA.get(j) <= teamB.get(i)){
                   count++;
                }
            }
            toReturn.add(count);
            count = 0;
                }
        
        return toReturn;
    } 
 */
   public static void main(String[] args) {
	  ArrayList<Integer>a = new ArrayList<Integer>();
	  a.add(1); a.add(2);
	  ArrayList<Integer> b = new ArrayList<Integer>();
	  b.add(2); b.add(4);
	  List<Integer>toR =  counts(a, b);
	  toR.get(0);
//	   String str = "a b ,";
//	   System.out.println(str.length());
//      Scanner scnr = new Scanner(System.in);
//      System.out.println("Enter input string:");
//      try {
//    	  String input = scnr.nextLine();  //w,dc
//    	    
//          while(!input.equalsIgnoreCase("q")) {
//        	  if(!input.contains(",")) {
//            	  System.out.println("Error: No comma in string.");
//            	  input = scnr.nextLine();
//              }
//        	  else {
//        	  String[] arrStr = input.split(","); //[w dc] 
//        	  String firstName = arrStr[0].replaceAll("\\s", "");
//        	  String lastName = arrStr[1].replaceAll("\\s", "");
//        	  System.out.println ("First word: " + firstName);
//        	  System.out.println("Last word: " + lastName + "\n");
//        	  
//        	   input = scnr.nextLine();
//          }
//          }
//      }
//      catch(Exception e) {
//    	  
//      }
    
   }
}
