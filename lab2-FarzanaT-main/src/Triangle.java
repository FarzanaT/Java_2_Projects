
public class Triangle { //NEW
	private double sideA;
	private double sideB;
	private double sideC;
	
	final public static String POLYGONSHAPE = "Triangle";
	final public static double DEFAULT_SIDE = 1;
	
	public Triangle() { //check
		sideA = DEFAULT_SIDE;
		sideB = DEFAULT_SIDE;
		sideC = DEFAULT_SIDE;
	}
	public Triangle(double a, double b, double c) { //OK
		if(isTriangle(a, b, c)) {
			sideA = a;
			sideB = b;
			sideC = c;
		}
		else {
			sideA = DEFAULT_SIDE;
			sideB = DEFAULT_SIDE;
			sideC = DEFAULT_SIDE;
		}
		
	}
	
	public Triangle (double [] sides) { 
		if(isTriangle(sides)) {
			sideA = sides[0];
			sideB = sides[1];
			sideC = sides[2];
		}
		
		else {
			sideA = DEFAULT_SIDE;
			sideB = DEFAULT_SIDE;
			sideC = DEFAULT_SIDE;
		}
	}
	
	public Triangle(Triangle triangle) {  
		
		if(triangle == null) {
			sideA = DEFAULT_SIDE;
			sideB = DEFAULT_SIDE;
			sideC = DEFAULT_SIDE;
		}
		else {
			sideA = triangle.getSideA();
			sideB = triangle.getSideB();
			sideC = triangle.getSideC();
			
		}
	}
// setters for Sides
public boolean setSideA(double sideA) {
		
		if(isTriangle(sideA, sideB, sideC)) {
			this.sideA = sideA;
			return true;
		}
		return false;
	}
	public boolean setSideB(double sideB) {
		
		if(isTriangle(sideA, sideB, sideC)) {
			this.sideB = sideB;
			return true;
		}
		return false;
	}
	
	public boolean setSideC(double sideC) {
		if(isTriangle(sideA, sideB, sideC)) {
			this.sideC = sideC;
			return true;
		}
		return false;
	}
	public boolean setSides(double [] newSide) {
		if(isTriangle(newSide)) {     
			this.sideA = newSide[0];
			this.sideB = newSide[1];
			this.sideC = newSide[2];
			return true;
		}
		else {
		return false;
		}
	}
// getters for Sides
	public double getSideA() {
		return sideA;
	}
	public double getSideB() {
		return sideB;
	}
	public double getSideC() {
		return sideC;
	}
	
	public double[] getSides() {
		double [] sides = new double [3];
		sides[0] = sideA;
		sides[1] = sideB;
		sides[2] = sideC;
		return sides;
	}
	
	public static boolean isTriangle(double a, double b, double c) { //OK
		if (a <= 0 || b <= 0 || c <= 0) {
			return false;
		}
		else if (a+b <= c || b+c <= a || a+c <= b ) {
			return false;
		}
		
		return true;
	}
	
	
// isTriangle Methods
	public static boolean isTriangle(double [] sides) {  //OK
		if(sides == null) {
			return false;
		}
		else if(sides.length != 3) {
			return false;
		}
		else if (sides[0] <= 0 || sides[1] <= 0 || sides[2] <= 0) {
			return false;
		}
		else if (sides[0]+sides[1] <= sides[2] || sides[1]+sides[2] <= sides[0] || sides[0]+sides[2] <= sides[1]) {
			return false;
		}
		return true;
	}
//Law of cosine
	public static double lawOfCosines(double a, double b, double c) {
		double angleC = Math.acos((a*a + b*b - c*c )/(2*a*b));
		angleC = Math.toDegrees(angleC);
		return angleC; 
	}
// getters for Angles
	public double getAngleA () {
		double angleA = lawOfCosines(sideB, sideC, sideA);
		return angleA;
	}
	
	public double getAngleB () {
		double angleB = lawOfCosines(sideA, sideC, sideB);
		return angleB;
	}
	
	public double getAngleC () {
		double angleC = lawOfCosines(sideA, sideB, sideC);
		return angleC;
	}
	public double [] getAngles () {
		double [] angles = new double [3];
		double angleA = lawOfCosines(sideB, sideC, sideA);
		double angleB = lawOfCosines(sideA, sideC, sideB);
		double angleC = lawOfCosines(sideA, sideB, sideC);

		angles[0] = angleA;
		angles[1] = angleB;
		angles[2] = angleC;
		
		return angles;
	}
	

   
	
//ToString Method
	public String toString () {
		
		return POLYGONSHAPE + "(" + String.format ("%.2f", sideA) +  ", " + String.format("%.2f", sideB) + ", " + String.format("%.2f", sideC) + ")";
	}
	

}
