package mockExam;

import java.util.Scanner;

//Leap year occurs in a year which is an integer multiple of 4 (except for years evenly divisible by 100, 
//which are not leap years unless evenly divisible by 400)

//The following code is not working for all leap years. Modify LeapChecker() to fix it.

public class LeapYear {
	
	public static String LeapChecker(int year) {
		boolean isLeap = false;
			
	    if(year % 4 == 0)
	    {
	        if(year % 100 == 0 && year / 4 == 0)
	        {
            // some coding is required //modified
	                isLeap = false;
	            
	        }
	        else
	            isLeap = true;
	    }
	    else {
	        isLeap = false;
	    }
	
	    if(isLeap == true)
	        return(year + " is a Leap Year.");
	    else
	    	return(year + " is not a Leap Year.");
	}
	    							
 public static void main(String[] args) {
 	
 	int year;
 	Scanner scan = new Scanner(System.in);
 	System.out.println("Enter any Year:");
 	year = scan.nextInt();    	    	
 	scan.close();
 	System.out.println(LeapChecker(year));    	
     
 }
}