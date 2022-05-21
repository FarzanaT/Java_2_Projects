package CS_OU;

import java.util.Scanner;
import java.util.ArrayList;

public class PhotoLineups {

	// TODO: Write method to create and output all permutations of the list of
	// names.
	public static void allPermutations(ArrayList<String> permList, ArrayList<String> nameList) {

		if (nameList.size() == 0) {
			for (int i = 0; i < permList.size(); i++) {
				System.out.print(permList.get(i) + " ");
			}
			System.out.println();

		}
		// create 2 copies
		// add remove
		else {

			for (int i = 0; i < nameList.size(); i++) {
				ArrayList<String> CnameL = new ArrayList<String>(nameList);
				ArrayList<String> CpermL = new ArrayList<String>(permList);
				String str = CnameL.remove(i);
				CpermL.add(str);
				allPermutations(CpermL, CnameL);
			}

		}
	}

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<String> permList = new ArrayList<String>();
		String name;
		name = scnr.next();
		// TODO: Read in a list of names; stop when -1 is read. Then call recursive
		// method.
		while (!name.equals("-1")) {
			nameList.add(name);
			name = scnr.next();
		}
		allPermutations(permList, nameList);
	}
}
