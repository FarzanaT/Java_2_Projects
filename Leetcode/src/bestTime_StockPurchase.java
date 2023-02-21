import java.util.Arrays;

public class bestTime_StockPurchase {
	public static void main(String[]args) {
		int [] prices = {2,1,2,0,1};
		System.out.println(maxProfit(prices));
	}

	
	    public static int maxProfit(int[] prices) {
	    	
	    	  int min = Integer.MAX_VALUE;
	          int maxProfit = 0;
	          for(int i = 0; i<prices.length; i++){
	              if(prices[i]<min){
	                  min = prices[i];
	              }
	              else if((prices[i]-min) > maxProfit) {
	                  maxProfit = prices[i] - min;
	              }
	          }
	          return maxProfit;
	    	
	        /*
	        find the least number in the array 
	        if its at the last index - return 0
	        else
	        run a for loop in the rest of the index - find the greatest digit
	        if the greatest number > least number 
	        subtract both - return 
	        */
	    	
	    	/*
	    	 * run a i ,j doubel for loop
	    	 * j = at the end = arr.length-1
	    	 * i from the start = 0 
	    	 * j-i = return the max possible 
	    	 * 
	    	 */
	        //prices = [7,1,5,3,6,4]
	    
//	        int min = prices[0];  
//	        int minIndex = 0;
//
//	        for(int i = 0; i<prices.length; i++){
//	            if(prices[i] < min) {
//	            	min = prices[i];
//	            	minIndex = i;
//	            }   
//	        }
//	        
//	        if(minIndex == prices.length-1) {  //edge case - min value being at the last 
//	        	return 0;
//	        }
//	        int maxIndex = minIndex+1; 
//	        int max = min;
//	        
//	    for(int i = minIndex+1; i<prices.length; i++) {
//	    	if(prices[i] > max) {
//	    		max = prices[i];
//	    	}
//	    }
//	    
//	    return max-min;
	        
	    }
	}

