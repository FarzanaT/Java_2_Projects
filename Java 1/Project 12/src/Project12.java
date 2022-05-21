// James Dizikes
// CS 1323/1324, Fall 2019
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Project12 {

	public static void main(String[] args)
		throws FileNotFoundException, IOException {

		final String FILENAME_COMMON = "common-dictionary.txt";
		final String FILENAME_PERSONAL = "personal-dictionary.txt";
		final int CAPACITY_PERSONAL_DICT = 100;
		String prompt = "Enter a word or 'quit' to stop: ";

		// Read the common dictionary and store the words in an array.
		ArrayList <String> Common_Dict = new ArrayList <String>();
		Common_Dict = readFile (FILENAME_COMMON); //ArrayList of common dictionary

		// Construct an oversize array to store the personal dictionary.
		ArrayList <String> Personal_Dict = new ArrayList <String>();  //ArrayList for personal dictionary
		
		// Construct a Scanner to read user input from the keyboard.
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Spell Checker");
		System.out.println("-------------");
		
		// Perform a priming read to get the first word.
		System.out.print(prompt);
		String word = keyboard.nextLine().toLowerCase();
		
		// Enter the user input loop.
		while (!word.equals("quit")) {
			
			// Check if the word is in either dictionary.
			if (checkSpelling(word, Common_Dict, Personal_Dict)) {
				System.out.println("The word is spelled correctly.");
			} 
			else {
				System.out.println("The word was not found in the "
					+ "dictionary.");			
				System.out.println("Would you like to add it to your personal "
					+ "dictionary (yes/no)?");
				String response = keyboard.nextLine().toLowerCase();
				
				if (response.equals("yes")) {  
					Personal_Dict.add(word);
					Collections.sort(Personal_Dict);
				}
			}
			
			// Get the next word from the user.
			System.out.println();
			System.out.print(prompt);
			word = keyboard.nextLine().toLowerCase();
		}
		
		keyboard.close();
		writeFile(FILENAME_PERSONAL, Personal_Dict);
		System.out.println("Goodbye!");
	}
	
		public static ArrayList<String> readFile(String fileName) throws FileNotFoundException  //METHOD 1 - ReadFile
		{
			Scanner file = new Scanner (new File (fileName));
			ArrayList <String> List = new ArrayList <String>();
			while (file.hasNextLine()) {
				List.add(file.nextLine());
			}
			file.close();
			
			return List;
		}
	
	public static boolean checkSpelling(String word, ArrayList<String> common, ArrayList<String> personal) {
		
		int index = Collections.binarySearch(common, word);
		if (index != -1) {
			return true;
		}

		int index2 = Collections.binarySearch(personal, word);
		if(index2 != -1) {
			return true;
		}
		
		return false;
	}
	
	// Write the nonempty elements of an oversize array to a given file.
	public static void writeFile(String fileName, ArrayList<String> list)
			throws FileNotFoundException {

		PrintWriter writer = new PrintWriter(fileName);
		writer.println(list);
		
		writer.close();
	}
}
