
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Project8 {
	public static void main(String[] args) throws FileNotFoundException {
		// System.out.println ("here");
		// String filename = "C:/Eclipse_Farz/Project8/src";
		// Scanner file = new Scanner(new File(filename));
		// String [] array = new String [readFile.length] ;

		//String location = "C:/Eclipse_Farz/Project8/src/movie-test.txt";
		String location = "movie-test1.txt";
		String[] movies = readFile(location);
		System.out.println(Arrays.deepToString(movies));

		lowercase(movies);
		findMostFrequent(movies);
		System.out.println(Arrays.deepToString(movies));

	}

	// method to convert into array
	public static String[] readFile(String filename) throws FileNotFoundException { // reding file and stroing each line
																					// as array element

		int count = 0;
		Scanner input1 = new Scanner(new File(filename));
		while (input1.hasNextLine()) { // looking for the
			count++;
			input1.nextLine();
		}
		String[] movies = new String[count];

		Scanner input2 = new Scanner(new File(filename));
		for (int i = 0; i < count; i++) {
			movies[i] = input2.nextLine();

		}
		return movies;
	}

	// tranforms to a lowercase element
	public static void lowercase(String[] array) {
		for (int i = 0; i < array.length; i++) {
			if (!array[i].equals(array[i].toLowerCase())) {
				array[i] = array[i].toLowerCase();
			}
		}
	}
	
	// finds the most frequent element 
	public static String findMostFrequent(String[] array) { //
		Arrays.sort(array);
		int count = 0;
		String element = "";

		for (int i = 0; i < array.length; i++) {
			String tempelement = array[i];
			int tempcount = 0;
			for (int j = 0; j < array.length; j++) {
				if (array[j].equals(tempelement)) {
					tempcount++;
				}
				if (tempcount > count) {
					count = tempcount;
					element = tempelement;
				}
			}
		}

		System.out.println("most frequent element: " + element);

		return element;
	}
}
