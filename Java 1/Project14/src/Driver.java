 import java.util.ArrayList;
 import java.util.Collections;
 import java.util.Scanner;
 import java.io.File;
 import java.io.FileNotFoundException;
 
/** Test the implementation of the Triangle class.
 * 
 * @author Deborah A Trytten
 *
 */
public class Driver {

	/** Demonstrate the use of aggregation by creating and modifying an ArrayList of Triangle
	 * objects.
	 * 
	 * @param args There are no command line arguments.
	 * @throws FileNotFoundException If the user entered data file is not found.
	 */
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner keyboard = new Scanner(System.in);
		
		// Objective 1--declare an ArrayList<Triangle>
		ArrayList<Triangle> list;
		
		System.out.println("Enter the name of the file");
		String fileName = keyboard.nextLine();
		
		// Objective 2--Read the contents of the ArrayList of Triangle objects from a file.
		list = readFromFile(fileName);
		
		// Objective 3--Print out the list, using the toString method in the ArrayList class.
		System.out.print("The original contents are\n[");
		for (int i = 0; i < list.size(); i++) {
			if (i != list.size()-1) {
				System.out.print (list.get(i) + ", ");
			}
			else {
				System.out.print (list.get(i));
			}
		}
		System.out.println ("]");
	
		
		//Objective 4--Call a method that prints out the Triangles in the ArrayList using the accessor methods in the Triangle class.
		System.out.println();
		System.out.println("Using Accessors");

		printList(list);
		
		// Objective 5--Set the lengths of all side As to a value that is read from the keyboard
		System.out.println();
		System.out.println("Enter the length of all side A");
		double a = keyboard.nextDouble();
		keyboard.nextLine();
		modifyAllSideA(list, a);
		System.out.println("After Side A changed");
		System.out.print("[");
		for (int i = 0; i < list.size(); i++) {
			if (i != list.size()-1) {
				System.out.print (list.get(i) + ", ");
			}
			else {
				System.out.print (list.get(i));
			}
		}
		System.out.println ("]");
		
		// Objective 6--Set the lengths of all side Bs to a value that is read from the keyboard
		System.out.println();
		System.out.println("Enter the length of all side B");
		double b = keyboard.nextDouble();
		keyboard.nextLine();
		modifyAllSideB(list, b);
		System.out.println("After Side B changed");
		System.out.print("[");
		for (int i = 0; i < list.size(); i++) {
			if (i != list.size()-1) {
				System.out.print (list.get(i) + ", ");
			}
			else {
				System.out.print (list.get(i));
			}
		}
		System.out.println ("]");
		
		// Objective 7--Set the lengths of all side Cs to a value that is read from the keyboard
		System.out.println();
		System.out.println("Enter the length of all side C");
		double c = keyboard.nextDouble();
		keyboard.nextLine();
		modifyAllSideC(list, c);
		System.out.println("After Side C changed");
		System.out.print("[");
		for (int i = 0; i < list.size(); i++) {
			if (i != list.size()-1) {
				System.out.print (list.get(i) + ", ");
			}
			else {
				System.out.print (list.get(i));
			}
		}
		System.out.println ("]");
		
		keyboard.close();
	}

	/** Use the accessor methods in the String class (not toString()) to print
	 * out the contents of a list.
	 * @param list The given list of Triangle objects.
	 */
	public static void printList(ArrayList<Triangle> list)throws FileNotFoundException
	{
		
		for (int i = 0; i<list.size(); i++) {
			System.out.println ("Triangle: "+ list.get(i).getSideA() + " " + list.get(i).getSideB() + " " + list.get(i).getSideC());
		}
		
	}
	
	/** Create a new ArrayList of Triangle objects that will store the data that is stored in
	 * a given file. The format of the file should be lines of three integral of floating
	 * point values, separated by spaces.
	 * @param fileName The name of the file that contains the data.
	 * @return A newly constructed ArrayList of Triangle objects that contains the data in the file.
	 * @throws FileNotFoundException If the given fileName cannot be found.
	 */
	public static ArrayList<Triangle> readFromFile(String fileName) throws FileNotFoundException
	{
		ArrayList <Triangle> list = new ArrayList <Triangle>();
		Scanner keyboard = new Scanner (new File(fileName));
		while (keyboard.hasNextLine()) {
			String line = keyboard.nextLine();
			int firstSpace = line.indexOf(" ");
			int lastSpace = line.lastIndexOf(" ");
			
			String sFirstValue = line.substring(0, firstSpace);
			double a = Double.parseDouble(sFirstValue);
			String sSecondValue = line.substring(firstSpace+1, lastSpace);
			double b = Double.parseDouble(sSecondValue);
			String sThirdValue = line.substring(lastSpace+1);
			double c = Double.parseDouble(sThirdValue);
			
			Triangle triangle = new Triangle (a, b, c);
			list.add(triangle);
			
		}
		keyboard.close();
		return list; 
	}
	
	/** Change all values of the first side of the Triangle to the given newValue.
	 * 
	 * @param list An initialized ArrayList of Triangle objects.
	 * @param newValue A new value for the first side of all triangles.
	 */
	public static void modifyAllSideA(ArrayList<Triangle> list, double newValue)
	{
		
		for (Triangle t: list) {
			t.setSideA(newValue);
		}
	}
	
	/** Change all values of the second side of the Triangle to the given newValue.
	 * 
	 * @param list An initialized ArrayList of Triangle objects.
	 * @param newValue A new value for the second side of all triangles.
	 */
	public static void modifyAllSideB(ArrayList<Triangle> list, double newValue)
	{
		for (Triangle t: list) {
			t.setSideB(newValue);
		}
	}
	
	/** Change all values of the third side of the Triangle to the given newValue.
	 * 
	 * @param list An initialized ArrayList of Triangle objects.
	 * @param newValue A new value for the third side of all triangles.
	 */
	public static void modifyAllSideC(ArrayList<Triangle> list, double newValue)
	{
		for (Triangle t: list) {
			t.setSideC(newValue);
		}
	}
}
