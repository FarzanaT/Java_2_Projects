package CS_OU;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TestInputType {

	public static void main(String[] args) throws FileNotFoundException  {
		// TODO Auto-generated method stub
		String filename ="testInput.txt";
	//	Scanner sc = new Scanner(new File(filename));
		//Scanner sc = new Scanner("testInput.txt");
//		int ruleNum = 0; //NA - initialized 
//		char tSymbol = ' ';
//		char fSymbol = ' ';
//		
//		String str = "";
		
		 Scanner file = new Scanner(new File(filename));
		 int rule = (file.nextInt());
		  file.nextLine();
		        
		  char falseSymbol = file.next().charAt(0);
		  char trueSymbol  = file.next().charAt(0);
		  file.nextLine();
		  String str = file.nextLine();
		  
		  System.out.println(rule);
		  System.out.println(falseSymbol);
		  System.out.println(trueSymbol);
		  System.out.println(str);
		
//		while(sc.hasNextLine()) {
//			// int ruleNum = Integer.parseInt(sc.nextLine());
//		//	int ruleNum = sc.nextInt();
//			//sc.nextLine();
//			sc.nextLine();
//			String strCh = sc.nextLine();
//			char tSymbol = strCh.charAt(0);
//			char fSymbol = strCh.charAt(2); //
//			String str = sc.nextLine();
//		//	System.out.println (ruleNum);
//			System.out.println (tSymbol);
//			System.out.println (fSymbol);
//			System.out.println (str);
//		}
		file.close();
//		FileReader reader = new FileReader("testInput.txt");
//		BufferedReader br = new BufferedReader (reader);
//		String str;
//		while((str = br.readLine()) != null) {
//			int ruleNum = sc.nextInt();
//			String strCh = sc.nextLine();
//			char tSymbol = strCh.charAt(0);
//			char fSymbol = strCh.charAt(2); //
//			String strJ = sc.nextLine();
//		//	System.out.println (ruleNum);
//			System.out.println (tSymbol);
//			System.out.println (fSymbol);
//			System.out.println (strJ);
//		}
//		br.close();
		
//		System.out.println (ruleNum);
//		System.out.println (tSymbol);
//		System.out.println (fSymbol);
//		System.out.println (str);
		//Generation generationA = new Generation(str, this.trueSymbol);
//		generationA.getStates(this.falseSymbol, this.trueSymbol);
		//generations.add(generationA);
		//this.rule = new Rule(ruleNum);
		
		//char Tsymbol = ' ';
				//char Fsymbol = ' ';
		

	}

}
