package CS_OU;

import java.util.Scanner;
import java.util.*;

public class driver {
       public static void main (String [] args) {
    	   Student student = new Student();
    	   String name = "Bo";
    	   String lastName = "Fung";
    	   double gpa = -1.0;
    	   String major = "CS";
    	   
    	   Student x = new Student(name, lastName, gpa, major);
    	   
    	   student.setFirstName(name);
    	   student.setLastName(lastName);
    	   student.setGPA(gpa);
    	  
    	   //student.firstName(name);
    	   System.out.println(student.getFirstName());
    	   System.out.println(student);
//        main something = new main();
//        int aha = something.main();
//        System.out.println ("aha: " + aha);
        
    }
       private int notMain (String str) {
    		return Integer.valueOf(str);
       }     
            


private int main() {
	System.out.println ("Read the book");
	return 42 + notMain ("18");
	
}
}


/*

BinarySearch ob = new BinarySearch(); 
 int result = ob.binarySearch(arr, x); 
 https://www.geeksforgeeks.org/java-program-to-perform-binary-search-on-arraylist/

*/