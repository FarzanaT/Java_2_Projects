// @Author_Farzana Tasnim
//Slot machine_Project 5

public class Project5 {
	public static void main(String[] args) {

		// double a = Math.random(1, 10);
		double a = Math.floor(Math.random() * 10) + 1; // random value generation
		double b = Math.floor(Math.random() * 10) + 1;
		double c = Math.floor(Math.random() * 10) + 1;

		if (a == b && b == c && a == c) { // nested if statement

			if (a == 7 && b == 7 && c == 7) {

				System.out.println("Your spin was " + (int) a + " " + (int) b + " " + (int) c + ".");
				System.out.println("You earned 500 points.");
			} else {

				System.out.println("Your spin was " + (int) a + " " + (int) b + " " + (int) c + ".");
				System.out.println("You earned 50 points.");
			}
		}

		else if ((a == b || a == c) || (b == a || b == c) || (c == a || c == b)) {

			if ((a == 7 && b == 7) || (b == 7 && c == 7) || (a == 7 && c == 7)) {
				System.out.println("Your spin was " + (int) a + " " + (int) b + " " + (int) c + ".");
				System.out.println("You earned 15 points.");
			} else {
				System.out.println("Your spin was " + (int) a + " " + (int) b + " " + (int) c + ".");
				System.out.println("You earned 3 points.");
			}
		}

		else if (!(a == b && b == c && a == c)) {

			System.out.println("Your spin was " + (int) a + " " + (int) b + " " + (int) c + ".");
			System.out.println("You earned -1 points.");
		}

	}
}
