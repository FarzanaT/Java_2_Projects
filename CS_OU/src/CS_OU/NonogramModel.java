

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NonogramModel {

	private static final String DELIMITER = " ";
	private static final int IDX_NUM_ROWS = 0;
	private static final int IDX_NUM_COLS = 1;

	private int[][] rowClues;
	private int[][] colClues;
	private CellState[][] cellStates;
	
	public NonogramModel(int[][] rowClues, int[][] colClues) {
		// TODO: Implement deepCopy. 
		// This is simple, and you should not ask about this on Discord.
		this.rowClues = deepCopy(rowClues);
		this.colClues = deepCopy(colClues);

		cellStates = initCellStates(getNumRows(), getNumCols());
	}
	
	public NonogramModel(File file) throws IOException {
		
		// Number of rows and columns
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String header = reader.readLine();
		String[] fields = header.split(DELIMITER);
		int numRows = Integer.parseInt(fields[IDX_NUM_ROWS]);
		int numCols = Integer.parseInt(fields[IDX_NUM_COLS]);

		// TODO: Initialize cellStates.
		cellStates = new CellState[numRows][numCols]; //not sure check

		for(int i = 0; i<numRows; i++) {
			for(int j = 0; j<numCols; j++) {
				cellStates[i][j] = CellState.EMPTY;
			}
		}
		// TODO: Read in row clues.
		rowClues = new int[numRows][];
		colClues = new int[numCols][];
		//String finalStr = "";
		String str = "";
	//starting loop work 
		
		for(int r = 0; r<numRows; r++) {
			str = reader.readLine();
			String [] arrayS = str.split(DELIMITER);
			int [] intArr =new int [arrayS.length];
			for(int i = 0; i<arrayS.length; i++) {
				intArr[i] = Integer.parseInt(arrayS[i]); //converting each string element to an int and storing into an array
			}
			rowClues[r] = intArr;  //so far good// each line added as int row 
		}
		for(int c = 0; c<numCols; c++) {
			str = reader.readLine();
			String [] arrayS = str.split(DELIMITER);
			int [] intArr =new int [arrayS.length];
			for(int i = 0; i<arrayS.length; i++) {
				intArr[i] = Integer.parseInt(arrayS[i]); //converting each string element to an int and storing into an array
			}
			colClues[c] = intArr;
		}

		// TODO: Read in column clues.
		
		 
		// Close reader
		reader.close();
	}

	public NonogramModel(String filename) throws IOException {
		// TODO: Fix this constructor
		// This is simple, and you should not ask about this on Discord.
		 this(new File(filename));  //fixed - use this evoke the class other constructor 
	}
	
	// TODO: Add more TODOs
	
	/* Helper methods */
	public int getNumRows() {
		return rowClues.length; //seems good
	}
	
	public int getNumCols() {
		return colClues.length; //ok
	}
	
	public CellState getCellState(int rowIdx, int colIdx) {
		return cellStates[rowIdx][colIdx]; //should be good 
	}
	public boolean getCellStateAsBoolean(int rowIdx, int colIdx) {  //should be good
		CellState cl = getCellState(rowIdx, colIdx);
		//cl.toBoolean(cl);
		if(CellState.toBoolean(cl) == true) {
			return true;
		}
		return false; 
	}
	
	public boolean setCellState(int rowIdx, int colIdx, CellState state) {
		//TO-DO
		if((state == null) || (isSolved())){
			return false;  //breaking here 
		}
		if(cellStates[rowIdx][colIdx] == state) {
			return false;
		}
		//??return a boolean value that indices
		cellStates[rowIdx][colIdx] = state; //setting the new cellState
		return true;
	}
	
	public int[][] getRowClues(){  //ok
		return deepCopy(this.rowClues);
	}
	public int[][] getColClues(){  //ok
		return deepCopy(this.colClues);
	}
	
	public int[] getRowClue(int rowIdx){
		if(rowClues[rowIdx] == null){
			throw new NullPointerException();
		}
		return (rowClues[rowIdx]).clone();  //returning the 1d array at the given index 
		
	}
	public int[] getColClue(int colIdx){
		if(colClues[colIdx] == null) {
			throw new NullPointerException();
		}
		return (colClues[colIdx]).clone();  //returning the 1d arra at the given index from 2d column parent array
	}
	
	public boolean isRowSolved(int rowIdx) {
		//check?
		if(Arrays.equals(projectCellStatesRow(rowIdx), getRowClue(rowIdx))) {
			return true;
		}
		
		return false;
	}
	public boolean isColSolved(int colIdx) {
		if(Arrays.equals(projectCellStatesCol(colIdx), getColClue(colIdx))) {
			return true;
		}
		
		return false; 
	}
	public boolean isSolved() {
		//to-do
		for(int r = 0; r<rowClues.length; r++) {
			if(isRowSolved(r) == false) {
				return false;
			}
		}
		for(int c = 0; c<colClues.length; c++) {
			if(isColSolved(c) == false) {
				return false;
			}
		}
		return true; 
	}
	public void resetCells() {
		for(int i = 0; i<rowClues.length; i++) {
			for(int j = 0; j<colClues.length; j++) {
				cellStates[i][j] = CellState.EMPTY;
			}
		}
	}
	public static ArrayList<Integer> project(boolean[] cells) {  //copied from project 4
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
	
	public int[] projectCellStatesRow(int rowIdx){
		//to-do
		boolean [] cellToPass = new boolean[this.getNumCols()];  //booelan array to pass in the project method
		
		for(int c = 0; c<this.getNumCols(); c++) {
			cellToPass[c] = getCellStateAsBoolean(rowIdx, c); //each 
				}
		project(cellToPass);//returning an Integer arrayList 
		int [] arrayR = new int[project(cellToPass).size()];
		for(int i = 0; i<project(cellToPass).size(); i++) {
			arrayR[i] = project(cellToPass).get(i);
		}
		
		return arrayR; 
	}
	
	public int[] projectCellStatesCol(int colIdx){
		//to-do
		boolean [] cellToPass = new boolean[this.getNumRows()];
		for(int r = 0; r<this.getNumRows(); r++) {
			cellToPass[r] = getCellStateAsBoolean(r, colIdx);  
				}
		project(cellToPass);//returning an Integer arrayList 
		int [] arrayC = new int[project(cellToPass).size()];
		for(int i = 0; i<project(cellToPass).size(); i++) {
			arrayC[i] = project(cellToPass).get(i);
		}
		return arrayC; 
	}
	
	
	
	// This is implemented for you
	private static CellState[][] initCellStates(int numRows, int numCols) {
		// Create a 2D array to store numRows * numCols elements
		CellState[][] cellStates = new CellState[numRows][numCols];
		
		// Set each element of the array to empty
		for (int rowIdx = 0; rowIdx < numRows; ++rowIdx) {
			for (int colIdx = 0; colIdx < numCols; ++colIdx) {
				cellStates[rowIdx][colIdx] = CellState.EMPTY;
			}
		}
		
		// Return the result
		return cellStates;
	}
	
	// TODO: Implement this method
	private static int[][] deepCopy(int[][] array) {  //done but check
		
		if(array == null) {
			return null; //check on condition  //or nullPointerException
		}
		int [][]toReturn = new int[array.length][]; 
			for(int i = 0; i<array.length; i++) {
				toReturn[i] = Arrays.copyOf(array[i], array[i].length);
			}
		
		return toReturn;
		//https://stackoverflow.com/questions/1564832/how-do-i-do-a-deep-copy-of-a-2d-array-in-java
		//int [][]toReturn = new int[array.length][]; 
		
		//return Arrays.stream(array).map(int[]::clone).toArray(int[][]::new); //this also works - confirmed 
	//internet cite https://www.techiedelight.com/create-copy-of-2d-array-java/
	}
	
	// This method is implemented for you. You need to figure out how it is useful.
	private static int[][] readClueLines(BufferedReader reader, int numLines)
			throws IOException {
		// Create a new 2D array to store the clues
		int[][] clueLines = new int[numLines][];
		
		// Read in clues line-by-line and add them to the array
		for (int lineNum = 0; lineNum < numLines; ++lineNum) {
			// Read in a line
			String line = reader.readLine();
			
			// Split the line according to the delimiter character
			String[] tokens = line.split(DELIMITER);
			
			// Create new int array to store the clues in
			int[] clues = new int[tokens.length];
			for (int idx = 0; idx < tokens.length; ++idx) {
				clues[idx] = Integer.parseInt(tokens[idx]);
			}
			
			// Store the processed clues in the resulting 2D array
			clueLines[lineNum] = clues;
		}
		
		// Return the result
		return clueLines;
	}
	
}
