import java.text.DecimalFormat;

public class Triangle {

	private double sideA;
	private double sideB;
	private double sideC;
	
	private DecimalFormat FORMATTER; //
	
	public Triangle (double sideA, double sideB, double sideC) {//constructor
		
		if (isTriangle(sideA, sideB, sideC)) {   //checking the each side with the constraints given, applying method isTriangle 
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
		}
		else {
		this.sideA = 1;  //if its false 
		this.sideB = 1;
		this.sideC = 1;	
		}
		
	}
	
	public double getSideA () {  //Accessors //to get/access the values of each side 
		
		return this.sideA; 
	}
	
	public double getSideB() {
		
		return this.sideB; 
	}
	
	public double getSideC() {
		
		return this.sideC;  
	}
	
	public boolean setSideA (double sideA) {    //MUTATORS // to set new values to each side 
		if (isTriangle(sideA, sideB, sideC)) {  //checking the each side with the constraints given 
			this.sideA = sideA;
			return true;
		}
		return false;	
	}
	
	public boolean setSideB (double sideB) {
		if (isTriangle(sideA, sideB, sideC)) {
			this.sideB = sideB;
			return true;
		}
		return false;
	}
	
	public boolean setSideC(double sideC) {
		if (isTriangle(sideA, sideB, sideC)) {
			this.sideC = sideC;
			return true;
		}
		return false;
	}
	
	private static boolean isTriangle (double a, double b, double c) {  //helper method to check the credibility of the values 
		
		double d = Math.max(c, (Math.max(a, b))); //constrains num1 max digit
		if ((a > 0 && b > 0 && c > 0)) { //checking positive digits 
		
		if (d == a) {
			if ((b+c)>a) {     //constraint num2 sum inequity formula
				return true;
			}
		}
		else if(d == b) {
			if ((a+c)>b) {
				return true;
			}
		}
		else if (d == c) {
			if ((a+b)>c) {
				return true;
			}
		}
		}
		
		return false;
	}
	
	public String toString () {  //returns each side of the triangle in String format 
		
		DecimalFormat FORMATTER = new DecimalFormat("#.###"); //creating decimalFormat object to keep the number concise 
		
		String a = FORMATTER.format(sideA);  //using decimalFormat object 
		String b = FORMATTER.format(sideB);
		String c = FORMATTER.format(sideC);
		
	
			return ("Triangle(" + a + ", " + b + ", " + c + ")");
		
	}
	
}
