import java.util.Scanner;

public class PopcornTimer {
   public static void printPopcornTime(int bagOunces) {
	   
	   double value = 53.4;
	   int count = 0;
	   final double LOWER_RANGE = 10.0;
	   final double UPPER_RANGE = 30.0;
	   while (LOWER_RANGE <= value && value <= UPPER_RANGE)
	   {
	   count = count + 1;
	//   value = value – 7.0;
	   
	   String a = "abcd";
	   
	   System.out.println (a.substring(0, 'c'));
	   } 
	   
/*
 if (bagOunces < 2){
  System.out.println ("Too small");  
 }
 else if (bagOunces > 10){
    System.out.println ("Too large");  
 }
 else {
    int num = 6 * bagOunces;
  System.out.println (num + " seconds");  
 }
//}
   }

   public static void main (String [] args) {
      Scanner scnr = new Scanner(System.in);
      int userOunces;

      userOunces = scnr.nextInt();
      printPopcornTime(userOunces);
   } */
}
}