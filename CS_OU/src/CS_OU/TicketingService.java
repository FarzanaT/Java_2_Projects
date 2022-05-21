package CS_OU;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class TicketingService {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String personName = "";
		int counter = 0;
		int youPosition = 0;

		Queue<String> peopleInQueue = new LinkedList<String>();

		personName = scnr.nextLine();
		while (!personName.equals("-1")) {

			// TODO: Add personName to peopleInQueue and
			peopleInQueue.add(personName);

			// determine position of "You" (youPosition)
			counter++;  //keeping track of every entry 
			if (personName.equals("You")) {
				youPosition = counter;  //got the you position //worked!
			}
			personName = scnr.nextLine();
		}

		System.out.println("Welcome to the ticketing service... ");
		System.out.println("You are number " + youPosition + " in the queue.");

		// TODO: In a loop, remove head person from peopleInQueue,
		// output their name and that they have purchased a ticket,
		// then output your position in the queue. When you are at
		// the head, output that you can purchase your ticket.
		int countn = youPosition;
		for (int i = 0; i<youPosition; i++) {
			String name = peopleInQueue.remove();
			
			countn--;
			if(name.equals("You")) {
				System.out.println("You can now purchase your ticket!");
				break;
			}
			else {
			System.out.println(name + " has purchased a ticket.");
			System.out.println("You are now number " + countn);
			}
			
		}
//		while(peopleInQueue.size() != 1) {
//			
//		}

	}
}
