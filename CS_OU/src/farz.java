import java.util.Scanner;
import java.util.*;
public class farz {
   public static int getMonthAsInt(String monthString) {
      int monthInt;
      
      // Java switch/case statement                                                                
      switch (monthString) {
         case "January": 
            monthInt = 1; 
            break;
         case "February": 
            monthInt = 2; 
            break;
         case "March": 
            monthInt = 3; 
            break;
         case "April": 
            monthInt = 4; 
            break;
         case "May": 
            monthInt = 5; 
            break;
         case "June": 
            monthInt = 6; 
            break;
         case "July": 
            monthInt = 7; 
            break;
         case "August": 
            monthInt = 8; 
            break;
         case "September": 
            monthInt = 9; 
            break;
         case "October": 
            monthInt = 10; 
            break;
         case "November": 
            monthInt = 11; 
            break;
         case "December": 
            monthInt = 12; 
            break;
         default: 
            monthInt = 0;
      }
      
      return monthInt;
   }

//   public static void main(String[] args) {
//      Scanner scnr = new Scanner(System.in);
//      String input = scnr.nextLine();
//      int Iday = 0;
//      int Imonth;
//      int Iyear = 0;
//      while(!input.equals("-1")){
//    	  String [] contents = input.split(" "); //returning all the 3 items //need to check date comma
//    	  for (String str : contents) {
//    		//  System.out.println(str); 
//    	  }
//    	  Imonth = getMonthAsInt(contents[0]); //
//    	  //got the day
//    	  try {
//    		  String dayInt = contents[1];
//    		  if(dayInt.charAt(dayInt.length()-1) == ',') {
//    			  
//        		  String day = dayInt.replaceAll(",", "");
//        				  //dayInt.substring(0, dayInt.length()-1);
//        		  Iday = Integer.parseInt(day);
//        	  }
//    		  Iyear = Integer.parseInt(contents[2]);
//    		  System.out.println(Imonth + "/" + Iday + "/" + Iyear);
//    	  }
//    	  catch (Exception e) {
//    		  
//    	  }
//    	  
//    	 
//    	  
//    	  
//    	   input = scnr.nextLine();
//       //  int month = Integer.parseInt(getMonthAsInt(input.))
//      }
//      // TODO: Read dates from input, parse the dates to find the ones
//      //       in the correct format, and output in m/d/yyyy format
//     
//   }
   
   
   public static void main(String[] args) {
	      Scanner scnr = new Scanner(System.in);
	      ArrayList<String>data  = new ArrayList<>();
	      String date;
	      String day;
	      String month;
	      String year;
	      
	      while(true) {
	    	  date = scnr.nextLine();
	    	  if(date.equals("-1")) {
	    		  break;
	    	  }
	    	  data.add(date);
	      }
	      
	      for(int i =0; i<data.size(); i++) {
	    	  try {
	    		 String input = data.get(i);
	    		 month = input.substring(0, input.indexOf(" "));
	    		 day = input.substring(input.indexOf(" ")+1, input.indexOf(","));
	    		 year = input.substring(input.indexOf(",")+2, input.length());
	    		 System.out.println(getMonthAsInt(month) + "/" + day + "/" + year);
	    	  }
	    	  catch(Exception e) {
	    		  
	    	  }
	     
	   }

}
}