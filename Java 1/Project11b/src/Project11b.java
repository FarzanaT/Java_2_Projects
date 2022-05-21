import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project11b {

	public static void main (String [] args) throws FileNotFoundException {
		
		Scanner input = new Scanner (System.in);
		System.out.println ("Enter your name");
		String reading = input.nextLine();
		reading = reading + ".txt";
		//System.out.println ("Enter your friend's name");
		//String reading2 = input.nextLine();
		
		String myArray [] = readArrayFromFile(reading);
		System.out.println ("Enter your friend's name");;
		String reading2 = input.nextLine();
		
		while (!(reading2.equals("Quit"))) {
			reading2 = reading2 + ".txt";
			String name = findMutualFriend(myArray, reading2);
			if (name != null){
				System.out.println (name + " is a mutual friend");
			}
			else {
				System.out.println ("You two do not have a mutual friend");
			}
			System.out.println ("Enter your friend's name");
			reading2 = input.nextLine();
			
			
		}
		
		System.out.println ("Bye");
		
	}
	
	public static boolean contains(String fileName, String element) throws FileNotFoundException {
		/* boolean result = false;
		Scanner input = new Scanner (new File(fileName));
		while (input.hasNext()) {
			if (input.next().equals(element)) {
				result = true;
			}
			input.nextLine();
		}
		input.close(); */
		
		//suggestion
		
		String[] array = readArrayFromFile(fileName);
		
		for(int i = 0; i<array.length;i++)
		{
			if(array[i].equals(element))
			{
				return true;
			}
		}
		
		return false;
		//suggestion ^
		
		
	}
	
	public static String findMutualFriend(String[] mine, String fileName) throws FileNotFoundException {
		String name = null;
		
		Scanner input = new Scanner (new File(fileName));
		
	/*	while (input.hasNext()) {
			for (int i = 0; i < mine.length; i++) {
				if(mine[i].equals(input.next())) {
					name = mine[i];
				}
			}
			input.nextLine();
		}
		input.close();
		*/
		
		//SUGGESTION
		
		for(int i = 0; i<mine.length;i++)
		{
			if(contains(fileName,mine[i]))
			{
				return mine[i];
			}
		}
		//suggestion ^
		
		return name;
		
	}
		public static String[] readArrayFromFile(String fileName) throws FileNotFoundException {
			Scanner input = new Scanner (new File(fileName));
			int count = 0; 
			
			while (input.hasNextLine()) {
				count++;
				input.nextLine();
			}
			input.close();
			
			input = new Scanner (new File(fileName));
			
			String [] fileArray = new String [count];
			
			for (int i = 0; i < count; i++) {
				fileArray[i] = input.nextLine();
			}
			input.close();
			
			return fileArray;
			
			
		}
}
