
// James Dizikes
// CS 1323/1324, Fall 2019
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Project9 {

	// main method
	public static void main(String[] args) throws FileNotFoundException, IOException {

		// final String FILENAME_COMMON =
		// "C:/Eclipse_Farz/Project9/src/common-dictionary.txt";
		final String FILENAME_COMMON = "common-dictionary.txt";
		final String FILENAME_PERSONAL = "personal-dictionary.txt";
		// "C:/Eclipse_Farz/Project9/src/personal-dictionary.txt";
		final int CAPACITY_PERSONAL_DICT = 100;
		String prompt = "Enter a word or 'quit' to stop: ";

		// Read the common dictionary and store the words in an array.
		String perfectDictionary[] = readFilePerfect(FILENAME_COMMON);
		// System.out.println ("here");
		System.out.println(Arrays.toString(perfectDictionary));

		// Construct an oversize array to store the personal dictionary.
		String oversizeDictionary[] = new String[CAPACITY_PERSONAL_DICT];
		// Read the personal dictionary, creating the file if it doesn't
		// exist. Store the words in an oversize array.
		int overDictSize = readFileOversize(FILENAME_PERSONAL, oversizeDictionary);
		// Construct a Scanner to read user input from the keyboard.
		Scanner input = new Scanner(System.in);
		// Perform a priming read to get the first word.
		System.out.println("Spell Checker");
		System.out.println("-------------");
		System.out.println("Enter a word or 'quit' to stop:");
		String word = input.nextLine();
		// Enter the user input loop.

		while (!word.equals("quit")) {

			if (checkSpelling(word, perfectDictionary, oversizeDictionary, overDictSize) == true) {
				System.out.println("The word is spelled correctly.");
			} else if (checkSpelling(word, perfectDictionary, oversizeDictionary, overDictSize) == false) {
				System.out.println("The word was not found in the dictionary.");
				if (overDictSize < CAPACITY_PERSONAL_DICT) {
					System.out.println("Would you like to add it to your personal dictionary (yes/no)?");

					String ans = input.nextLine();
					if (ans.equals("yes")) {
						oversizeDictionary[overDictSize] = word;
						overDictSize++;
					}

				}

			}
			System.out.println("Enter a word or 'quit' to stop:");
			word = input.nextLine();
		}
		System.out.println("Goodbye!");

		writeFile(FILENAME_PERSONAL, oversizeDictionary, overDictSize);
		// Check if the word is in either dictionary.

		// If the user responds "yes" and there is room in the oversize
		// array, add the word to the end of the array and sort it.

		// Get the next word from the user.
	}

	// Read each line of a file and store them in a perfect size array. //METHOD 1
	public static String[] readFilePerfect(String filename) throws FileNotFoundException {

		Scanner keyboard = new Scanner(new File(filename));
		// Count the number of lines in the file.
		int count = 0;
		while (keyboard.hasNextLine()) {
			count++;
			keyboard.nextLine();
		}
		keyboard.close();
		keyboard = new Scanner(new File(filename));
		// Use the number of lines to construct a perfect size array.
		String[] perfectDict = new String[count];
		// Loop through the file again, adding each line to the array.
		for (int i = 0; i < count; i++) {
			perfectDict[i] = keyboard.nextLine();
		}
		keyboard.close();
		// Return the lines of the file.
		return perfectDict;
	}

	// Read each line of a file and store them in an oversize array. If the //METHOD
	// 2
	// file does not exist, create an empty file with the given name.
	public static int readFileOversize(String filename, String[] array) throws FileNotFoundException, IOException {

		// Construct a file object for the file with the given name.
		File file = new File(filename);

		// If the file does not exist, create it.
		file.createNewFile();

		// Construct a scanner to read the file.
		Scanner fileScanner = new Scanner(file);

		// Store each line of the file in the array. Exit the loop when the
		// array is full or the entire file has been read.
		int i = 0;
		while (fileScanner.hasNextLine()) {
			array[i] = fileScanner.nextLine();
			i++;
		}

		fileScanner.close();

		return i;
	}

	// Return true if word is in either array; otherwise, return false. Note
	// //METHOD 3
	// that the arrays are sorted, so binary search can be used.
	public static boolean checkSpelling(String word, String[] common, String[] personal, int sizePersonal) {

		boolean result = false;

		Arrays.sort(personal, 0, sizePersonal);

		// binary search
		if ((Arrays.binarySearch(common, word)) >= 0 || (Arrays.binarySearch(personal, 0, sizePersonal, word)) >= 0) {
			result = true;
		} else {
			result = false;
		}

		return result;
	}

	// Write the nonempty elements of an oversize array to a given file. //METHOD 4
	public static void writeFile(String filename, String[] array, int size) throws FileNotFoundException {

		PrintWriter writer = new PrintWriter(filename);

		// Print out the array one line at a time to the file
		for (int i = 0; i < size; i++) {
			writer.println(array[i]);
		}

		// Close the file; otherwise, the contents will be lost.
		writer.close();
	}
}
