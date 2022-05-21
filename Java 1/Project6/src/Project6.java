//@author Farzana Tasnim - 113533669
//Project 6

import java.util.Scanner;
public class Project6 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // scanner construction
		System.out.println("Response Dial Simulator ");
		System.out.println("----------------------- ");

		iclicker("Enter the next setting (1-5) or -1 to stop.", input, -1); // method call, sentinel as -1
		input.close();
	}

	public static void iclicker(String prompt, Scanner input, int sentinel) { // method for iClicker starts

		int countPos = 0;
		int countNeg = 0;
		int countNeutral = 0; //counting for dial changes

		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0; //counting for each dial when called
		int fixValue = 3; //3 as the inital dial

		System.out.println("Initial setting: " + fixValue); //initial setting print

		System.out.println(prompt);  //prompt print
		int value = input.nextInt(); //input from Scanner in the method
		input.nextLine();

		if (value != sentinel) { // Sentinel controlled loop

			if (value == 3) { //comparing input with the fixValue 3 starts 
				System.out.println("No change: " + value + " to " + value);
				System.out.println("Current setting: " + value);
				countNeutral = countNeutral + 1;
				count3++;
			}

			else {
				if (value == 1) {
					System.out.println("Negative change: 3" + " to " + value);
					System.out.println("Current setting: " + value);
					count1++;
					countNeg++;
				} else if (value == 2) {
					System.out.println("Negative change: 3 to " + value);
					System.out.println("Current setting: " + value);
					count2++;
					countNeg++;
				} else if (value == 4) {
					System.out.println("Positive change: 3 to " + value);
					System.out.println("Current setting: " + value);
					count4++;
					countPos++;
				} else if (value == 5) {
					System.out.println("Positive change: 3 to " + value);
					System.out.println("Current setting: " + value);
					count5++;
					countPos++;
				}
			}   //comparing input with the fixValue 3 ends 

			System.out.println("Enter the next setting (1-5) or -1 to stop.");

			int value1 = input.nextInt(); // new input for value1
			input.nextLine();

			while (value1 != sentinel) { 											// Sentinel controlled loop
				if (value == value1) {   											//comparing value and value1 starts
					System.out.println("No change: " + value + " to " + value1);
					System.out.println("Current setting: " + value1);
					countNeutral++;
				}

				else if (value1 < value) {
					System.out.println("Negative change: " + value + " to " + value1);
					System.out.println("Current setting: " + value1);
					countNeg++;
				}

				else if (value1 > value) {
					System.out.println("Positive change: " + value + " to " + value1);
					System.out.println("Current setting: " + value1);
					countPos++;
				}  																			//comparing value and value1 ends

				if (value1 == 1) {
					count1++; 		//incrementing count values for each dial when called
				}

				else if (value1 == 2) {
					count2++;
				} else if (value1 == 3) {
					count3++;
				} else if (value1 == 4) {
					count4++;
				} else if (value1 == 5) {
					count5++; 
				}  

				System.out.println("Enter the next setting (1-5) or -1 to stop.");
				value = value1;								//value as value1, so that new input gets compared with the latest last input
				value1 = input.nextInt();
				input.nextLine();

			}

			System.out.println();
			System.out.println("Response Summary ");
			System.out.println("---------------- ");
			System.out.println("1 was chosen " + count1 + " time(s).");
			System.out.println("2 was chosen " + count2 + " time(s).");
			System.out.println("3 was chosen " + count3 + " time(s).");
			System.out.println("4 was chosen " + count4 + " time(s).");
			System.out.println("5 was chosen " + count5 + " time(s).");
			System.out.println();

			System.out.println("Positive changes: " + countPos);
			System.out.println("Negative changes:" + countNeg);
			System.out.println("No changes: " + countNeutral);
		}
	} //mehtod iClicker Ends 

} //Project6 class Ends 
