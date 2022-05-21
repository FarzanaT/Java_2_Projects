import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
		public static ArrayList <Triangle> triangle; 
	public static void main(String[] args) throws FileNotFoundException {
		
		/***
		Triangle triangle = new Triangle(5, 5, 5);  //creating a Triangle object with the expected values 
		
		System.out.println ("The three sides of the legal triangle are: " + triangle.getSideA() + " " + triangle.getSideB() + " " + triangle.getSideC());
		
		triangle.setSideA(9); //using mutators to set new values to each sides 
		triangle.setSideB(6);
		triangle.setSideC(7);
		
		System.out.println ("A was set to 9, then B to 6 and C to 7: " + triangle.toString()); //using toString method to print the current values of each sides 
		System.out.println();

		Triangle triangle2 = new Triangle(2, 2, 10);   //creating another Triangle object 
		System.out.println ("The illegal triangle contained: " + triangle2.toString());
		
		triangle2.setSideA(7);
		System.out.println ("Changed side A to 7: " + triangle2.toString());
		triangle2.setSideB(-10);  //setting illegal values to check the conditions applied 
		System.out.println ("Changed side B to -10: " + triangle2.toString());
		triangle2.setSideC(21);
		System.out.println ("Changed side C to 21: " + triangle2.toString());  
		
		*/
		
		//System.out.println ("Enter the name of the file");
		//Scanner input = new Scanner (System.in);
		//String name = input.nextLine();
	    triangle = readFile ("Sample.txt");
		//triangle = readFile ("C://Eclipse_Farz//Project14");
		
				
		for (Triangle t: triangle) {
			System.out.println (t);
		}
		
	}
	
	public static ArrayList<Triangle> readFile (String fileName)throws FileNotFoundException {
		
		Scanner file = new Scanner (new File(fileName));
		int numItems = file.nextInt();
		ArrayList <Triangle> triData = new ArrayList <Triangle>(numItems); // to inherit Triangle class??
		file.nextLine();
		
		for (int i = 0; i < numItems; i++) {
			String line = file.nextLine();
			int firstSpace = line.indexOf(" ");
			int lastSpace = line.lastIndexOf(" ");
			
			String sFirstValue = line.substring(0, firstSpace);
			int FirstValue = Integer.parseInt(sFirstValue);
			String sSecondValue = line.substring(firstSpace+1, lastSpace);
			int SecondValue = Integer.parseInt(sSecondValue);
			String sThirdValue = line.substring(lastSpace+1);
			int ThirdValue = Integer.parseInt(sThirdValue);
			
			Triangle triangle = new Triangle (FirstValue, SecondValue, ThirdValue);
			triData.add(triangle);
			
			
		}
		
		
		return triData; 
	}

}
