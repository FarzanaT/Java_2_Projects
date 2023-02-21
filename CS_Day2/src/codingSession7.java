import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class codingSession7 {
public static void main(String[]args) {
//	String str= "123";
//	int a  = Integer.valueOf(str);
//	System.out.println(a);
//	List<Integer>result = new ArrayList<>();
//	result.add(2);
//	result.add(2);
//	result.add(1);
//	Collections.sort(result);
//	System.out.println(result);
	Stack<String>s = new Stack<String>();
	s.push("a");
	s.push("b");
	
	//String finalS = "a";
	StringBuilder sb = new StringBuilder();
	sb.append(s.pop());
	
//	 for(int i = 1; i<4; i++){
//         sb.append(finalS); // check // try eclipse
//     }
//	 finalS = sb.toString();
	 System.out.println(sb.toString());

}

public static boolean canAttendAll(int[][] intervals) {
    
    
    
    int [] currentInt = intervals[0];
    // for(int[]interval : intervals){
    //     int currentIntEnd = currentInt[1];
    //     int nextFirst = interval[0];
    //     int nextEnd = interval[1];
    //     if(currentIntEnd > nextFirst){
    //         return false;
    //     }
    //     else{
    //        currentInt = interval; 
    //     }
    // }
    for(int i = 1; i< intervals.length; i++){
        int currentIntEnd = currentInt[1];
        int nextFirst = intervals[i][0];
    
     if(currentIntEnd > nextFirst){
            return false;
        }
        else{
            int[]newElem =  {intervals[i][0], intervals[i][1]};
           currentInt = newElem;
        }
    }
    
    return true;
}

public int[][] merge(int[][] intervals) {
    /*
    edge cases-> only one element 
                 or no element 
      [[1,3],
      [2,6],
      [8,10],
      [15,18]]
      sort the 2D array with Built-in function -> Understand comparator Method 
      
      create a returning 2D array - create an arrayList - 
     -> now that its sorted [[1,3],[2,6],[8,10],[15,18]]
      run a double for loop for traversing
      compare the END of 1st with the START of 2nd 
      if(f[1] >= s[0]) -> merge confirmation 
      new element with -> f[0], s[1]
      add new elem to returning 2D array
      convert arrayList to a 2D array 
      

    */
	//edge cases 
	if(intervals.length <= 1) { //one element || empty array 
		return intervals; 
	}
    
	List<int[]>result = new ArrayList<>();
    Arrays.sort(intervals, (ob1, ob2) -> Integer.compare(ob1[0],  ob2[0]));  //WORK - interesting
    int current_elem[] = intervals[0];
    result.add(current_elem); //first elem added
    for(int[] interval: intervals) { //interval -> each array element [[1,3],[2,6],[8,10],[15,18]]
    	int firstStart = interval[0];
        int firstEnd = interval[1];
        if(current_elem[1] >= firstStart) {
        	current_elem[1] = Math.max(firstEnd, current_elem[1]);
        }
        else {
        	current_elem = interval;
        	result.add(current_elem);
        }
        
    }
    return  result.toArray(new int[result.size()][]); //converting into a 2D array - 
   
}
}

