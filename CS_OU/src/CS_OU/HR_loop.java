package CS_OU;
import java.util.*;
import java.io.*;
public class HR_loop {
	

	    public static void main(String []argh){
	        Scanner in = new Scanner(System.in);
	        int t=in.nextInt();
	        
	        for(int i=0;i<t;i++){
	        	System.out.println("input pls: ");
	            int a = in.nextInt();
	            int b = in.nextInt();
	            int n = in.nextInt();
	            int temp = 0;
		        int storePow = 0;
	            for (int j = 0; j<n; j++)
	            {
	                int pow = (int)Math.pow(2, j)*b;
	                storePow = storePow + pow;
	                temp = storePow + a;
	                System.out.print(temp + " ");
	            }
	            System.out.println();
	        }
	        
	        
	        in.close();
	    }
	
}
