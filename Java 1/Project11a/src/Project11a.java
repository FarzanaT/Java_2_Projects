import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Project11a {
	public static void main (String [] args) throws FileNotFoundException {
		System.out.println ("Enter the file name");
		Scanner input = new Scanner (System.in);
		String fileName = input.nextLine();
		
		System.out.println ("Usage summary");
		double [] newDoubleArray = readFile(fileName);
		int [] newIntArray = summarizeDataByHour(newDoubleArray);
		
		for (int i = 0; i <newIntArray.length; i++) {
			if (newIntArray[i] != 0) {
				System.out.println ("From " + i + " to " + (i+1) + " there were " + countInRange(newDoubleArray, i, i+1) + " entries");
			}
		}
		
		
	}
	
	public static int countInRange(double[] data, int lower, int upper) {
		int count = 0;
		for (int i = 0; i < data.length; i++) {
			if (data[i] >= lower && data[i] < upper) {
				count++;
			}
		}
		
		return count;
	}
	
	public static double[] readFile(String fileName)throws FileNotFoundException {
		
		Scanner input = new Scanner (new File(fileName));
		double [] fileArray;
		int count = input.nextInt();
		
		//input = new Scanner (new File(fileName));
	    fileArray = new double [count];
	    
	    for(int i = 0; i < count; i++) {
	    		fileArray[i] = input.nextDouble();
	    	
	    }
	    input.close();
		
		
		return fileArray;
	}
	
	public static int[] summarizeDataByHour(double[] data) {
		
		int [] hourArray = new int [24];
		
		for (int i = 0; i < data.length; i++) {
			
			hourArray[(int)data[i]]++;
		}
		
		return hourArray;
	}

}
