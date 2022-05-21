package CS_OU;

import java.util.Scanner;

public class interface_drJ {
	public static void main(String [] args) {
		Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        
        if (a < 0 || b < 0){
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
        else{
            System.out.println(a*b);
        }
	}
	
}
