import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
	
//	public static ArrayList<String> remove() {
//		
//		return null;
//	}
	public static String open(String fileName)throws FileNotFoundException{  //done
		//File file = new File(fileName);
		Scanner reader = new Scanner(new File(fileName));
		String str = "";
		while(reader.hasNextLine()) {
			//str += reader.nextLine();
			System.out.println(reader.nextLine());
		}
		return str;
	}
	public static void save(String fileName) throws IOException {  //
		FileWriter fl = new FileWriter(fileName); //writing the returned subjects to the remaining course file 
		//fl.write(reString());
		fl.close();
	}
	
	public static void add(String newSub) throws IOException {   //done  //adds successfully
		FileWriter fw = new FileWriter("currentCourses.txt", true);
		FileWriter fwA = new FileWriter("allCourses.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		BufferedWriter bwA = new BufferedWriter(fwA);
		PrintWriter pw = new PrintWriter(bw);
		PrintWriter pwA = new PrintWriter(bwA);
		pw.println(newSub);
		pwA.println(newSub);
		pw.flush();
		pwA.flush();
		
	}
	public static String reString(String fileName) throws FileNotFoundException {
		String input = "";
	      Scanner sc = new Scanner(new File(fileName));
	    //  StringBuffer sb = new StringBuffer();
	      StringJoiner strJ= new StringJoiner("\n");
	      while (sc.hasNextLine()) {
	         input = sc.nextLine();
	        // sb.append(input);
	         strJ.add(input);
	      }
	      return strJ.toString();
	}
	
	public static void remove(String course, String currFile, String allFile)throws FileNotFoundException {
		//find how to check if a file contain certain string 
		String Cresult = reString(currFile);
		String Aresult = reString(allFile);
		
		Cresult = Cresult.replace(course, "");
		Aresult = Aresult.replace(course, "");
		//deleting the white spaces after removing Strip()
		PrintWriter Cwriter = new PrintWriter(new File(currFile));
		PrintWriter Awriter = new PrintWriter(new File(allFile));
		Cwriter.append(Cresult);
		Awriter.append(Aresult);
		
		Cwriter.flush();
		Awriter.flush();
		
	}
	
	
	public static void main(String [] args) throws IOException {
		String prompt = "Please select an option from the following index:" + "\n"
				+ "1. Display all courses | " 
				+ "2. Current courses |" 
				+ "3. Remaining courses |" 
				+ "4. Add courses |" 
				+ "5. Remove courses |"
				+ "To exit, enter -1";
		System.out.println(prompt);
		System.out.println("-----------------------------");
		Scanner scn = new Scanner (System.in);
		String input = scn.next();
		if(input.equals("-1")) {
			System.out.println("You got this Sooner!");
		}
		while(!input.equals("-1")) {
			
			if(input.equals("1")) {
				//open main all courses txt file with
				open("allCourses.txt");  //open works
			}
			if(input.equals("2")) {  
				//current courses txt file
				open("currentCourses.txt");
			}
			if(input.equals("3")) {
				//remaining courses
				open("remainingCourses.txt");
			
			}
			if(input.equals("4")) {
				//add course to current file
				System.out.println("Please enter the course details.");
				input = scn.next();
				add(input);
				System.out.println("Course added! Yay!!");
				
			}
			if(input.equals("5")) {
				//remove course //update remaining courses
				System.out.println("Which course would you like to remove?");
			//	String removeCourse = scn.next();
				String newIn = scn.next();
				remove(newIn, "currentCourses.txt", "remainingCourses.txt");
			}
			
			System.out.println("---------------------------------------");
			System.out.println(prompt);
			input = scn.next();
			
			
		}
	}
}
