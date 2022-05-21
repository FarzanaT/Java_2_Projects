import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** This project was inspired by word jumbles. The program randomly chooses a 
 * word from a dictionary, scrambles the letters, and lets the user guess the 
 * unscrambled word. After every incorrect guess, part of the unscrambled word 
 * is shown. The number of points earned for a correct guess decreases with the 
 * number of guesses.
 * 
 * @author Deborah A. Trytten
 * @version 1.1
 * Updated to v1.1 by James Dizikes on Sept 30, 2019.
 */
public class HW22 
{
	// Note: Any method that opens a file must be able to throw the file not 
	// found exception.
	public static void main(String[] args) throws FileNotFoundException
	{
		// Construct a Scanner object to read guesses from the keyboard.
		Scanner keyboard = new Scanner(System.in);
		
		// The game loop runs until this variable is no longer "yes".
		String s = "HackerRank";
		String s2 = keyboard.nextLine();
		System.out.println (s + " " + s2);
		
		}
}



/***
 * public class Book{
private String title;
private String author;
private String tableOfContents = "";
private int nextPage = 1;
public Book (String title, String author){
	this.title = title;
	this.author = author;	
}
public void addChapter (String title, int pageNum){
	tableOfContents += "\n" + title + "..." + nextPage;
	nextPage += pageNum;
}
public int getPages (){
return this.nextPage-1;	
}
public String getTableOfContents (){
return this.tableOfContents;	
}
public String toString (){
String var = title + "\n" + author;
return var;
}	
}
 * 
 * 
 */



