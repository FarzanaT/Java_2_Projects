import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class NonogramMakerModel {
	private static final char EMPTY_CELL = '0';
	private static final char FILLED_CELL = '1';

	private int numRows;
	private int numCols;

	private boolean[] grid;

	public NonogramMakerModel(int numRows, int numCols) {
		if(numRows <= 0 || numCols <= 0) {
			throw new IllegalArgumentException();
		}
		this.numRows = numRows;
		this.numCols = numCols;
		grid = new boolean[numRows * numCols];
	}

	public NonogramMakerModel(File file) throws FileNotFoundException { // works good w/o the toString() method

		// how to read data from a object File
		Scanner fileReader = new Scanner(file); // check if they want the string format
		String firstLine = fileReader.nextLine(); // reading the first line // 10 10
		String row_col[] = firstLine.split(" "); // storing both the values in an array in String format
		int intRowCol[] = new int[2];
		for (int i = 0; i < row_col.length; i++) {
			intRowCol[i] = Integer.parseInt(row_col[i]); // adding each element as integer
		}
		this.grid = new boolean[intRowCol[0] * intRowCol[1]]; // initialising the grid array length with the new row and col
															// from the file firstline
		this.numRows = intRowCol[0];  //initialising numR and numC
		this.numCols = intRowCol[1];
		
		//counting lines to skip 
		int numRC = intRowCol[0] + intRowCol[1]; // 10 + 10 lines to skip (20 lines of numerators)

		ArrayList<Character> ALchar = new ArrayList<Character>();
		int count = 0;
		while (fileReader.hasNextLine()) {
			// loop through the char array [0,0,0,0,0,0,1] //can we store all the array
			// create a new character arraylist
			fileReader.nextLine();
			count++;
			if (count == numRC) {
				for (int i = 0; i<this.numRows; i++) {
				String str = fileReader.nextLine();
				char[] strArr = str.toCharArray(); // generating an array of each String line
				for (Character ch : strArr) {
					ALchar.add(ch); // added the 0,0,1... characters in the list
				}
			}
			}

		}
		// assuming the list to have all the values by this point //now to fill the
		// actual array with b values
		for (int i = 0; i < ALchar.size(); i++) {
			if (ALchar.get(i) == EMPTY_CELL) {
				grid[i] = false;
			} else if (ALchar.get(i) == FILLED_CELL) {
				grid[i] = true;
			}
		}
		// by the point the grid array should have all the boolean values

	}

	public NonogramMakerModel(String filename) throws FileNotFoundException { // done
		this(new File(filename));

	}

	public boolean[] getGrid() {
		return this.grid.clone(); // returning the copy of the grid array
	}

	public boolean getCell(int rowIdx, int colIdx) {
		return this.grid[rowIdx * this.numCols +colIdx]; // cell state at the given index of the boolean array grid
	}

	public void setCell(int rowIdx, int colIdx, boolean state) {
		// have to update the cell state of the grid b array at the idx with the cell
		// state
		int idx = rowIdx * this.numCols + colIdx ;
		this.grid[idx] = state;
	}

	public int getNumRows() {
		return this.numRows;
	}

	public int getNumCols() {
		return this.numCols;
	}

	public static ArrayList<Integer> project(boolean[] cells) {
		ArrayList<Integer> totoalList = new ArrayList<Integer>();
		int count = 0;

		for (int i = 0; i < cells.length; i++) {
			if (cells[i] == true) {
				count++;
				if ((i == cells.length - 1) && cells[i] == true) { // checking for the last case
					totoalList.add(count);
				}
			}
			// the last true case not getting counted

			else if (cells[i] == false) {
				totoalList.add(count);
				count = 0;
			}

		}
		// run through the arrayList -> if all 0s return 1 zero -> else, delete the
		// zeros
		ArrayList<Integer> newA = new ArrayList<Integer>();
		Integer sum = 0;
		for (Integer x : totoalList) {
			sum += x;
		}
		if (sum == 0) { // 0 case passed
			// ArrayList <Integer> newA = new ArrayList <Integer>();
			newA.add(sum);
			return newA;
		} else {
			for (Integer x : totoalList) {
				if (x != 0) {
					newA.add(x);
				}
			}
		}

		return newA;
	}

	public ArrayList<Integer> projectRow(int rowIdx) { //lowkey done
		//what if row num is 0 //working for 0 cases fine
//		boolean [] newRowArray = new boolean [this.numCols]; //
//		if(rowIdx == 0) {
//			for(int i = 0; i<this.numCols; i++) {
//				newRowArray[i] = grid[i];
//			}
//		}
//		else {   //check //heres the problem  //row - 2
//		int Srow = rowIdx * this.numCols; //1*3 = 3 //starting at 3 //2*cols = 8
//		int Trow = Srow + (this.numCols); //8+4 = 12
//		for (int i = Srow, j = 0; i<Trow; i++, j++) {
//			newRowArray[j] = grid[i]; //getting all the 10 values from row 3
//		}
//		}
		boolean [] newRowArrayN = Arrays.copyOfRange(grid, rowIdx*this.numCols, numCols*(1+rowIdx));
		return project(newRowArrayN);
	}

	public ArrayList<Integer> projectCol(int colIdx) {
		//create the array // HOW??
		boolean [] newColArray = new boolean [this.numRows];
		//if(colIdx == 0) {
			for(int i = colIdx, j = 0; i<(this.numCols*this.numRows); i+=this.numCols, j++) { //i=0; i<12; i+4
				newColArray[j] = grid[i];
			}

		
		return project(newColArray);

	}

	public void saveToFile(String fileName) throws IOException {
		//File file = new File(fileName); 
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		bw.write(toString());
		bw.close();
		
	}

	public String toString() {
		String finalStr = "";
		// StringJoiner str = new StringJoiner();
		// rows and cols added
		StringJoiner strR = new StringJoiner(" ", "", "");
		StringJoiner strC = new StringJoiner(" ", "", "");
		String numRC = Integer.toString(this.numRows) + " " + Integer.toString(this.numCols);
		finalStr += numRC + System.lineSeparator();
		// project each row //loop through all the rows
		for (int row = 0; row < this.numRows; row++) {
			
			ArrayList<Integer> nR = projectRow(row); // returning an arrayList of numbers for each row
			for (Integer n : nR) {
				strR.add(Integer.toString(n)); // adding each of the contents of the arraylist to a new line of the
											// returning String
			}
			finalStr += strR.toString() + System.lineSeparator(); // adding a new line
			strR = new StringJoiner(" ", "", "");
		}
		// by now all the row contents should be added with new lines // same strategy
		// to follow for cols
		// project each col //loop through all the cols
		for (int i = 0; i < this.numCols; i++) {
			ArrayList<Integer> nC = projectCol(i); // returning an arrayList of numbers for each col
			for (Integer n : nC) {
				strC.add(Integer.toString(n)); // adding each of the contents of the arraylist to a new line of the
												// returning String
			}
			finalStr += strC.toString() + System.lineSeparator(); // adding a new line
			strC = new StringJoiner(" ", "", "");
		}
		
		String strN = "";
		StringJoiner strB = new StringJoiner (System.lineSeparator(), "", "");
		for (int  r = 0; r<this.numRows; r++) {
			for (int c = 0; c<this.numCols; c++) {
				boolean b = getCell(r, c);
				if(b == true) {
					strN += "1";
				}
				else if(b == false) {
					strN += "0";
				}
			}
			strB.add(strN);
			strN = "";
			
		}
		finalStr += strB.toString();

		return finalStr; 
}

}
