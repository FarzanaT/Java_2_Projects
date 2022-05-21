import java.text.DecimalFormat;

/** This class will store data that can legally represent a Triangle. The three side lengths are
 * stored. If these lengths are a, b, and c, then a+b>c, a+c>b and b+c>a. In additional all
 * three side lengths must be non-negative.
 * @author Deborah A Trytten
 *
 */
public class Triangle {

	// The lengths of the sides of the three triangles.
	// Instance data
	private double sideA;
	private double sideB;
	private double sideC;
	
	// Class data
	// This is used to format the output in the toString method.
	private static final DecimalFormat FORMATTER = new DecimalFormat("#.###");
	
	// Constructor
	/** Construct a Triangle object with the given side lengths. If the side lengths
	 * are not legal, all the sides will be made to be length 1. The side lengths are not equal
	 * when the sum of any two sides is larger than the third side. Negative side lengths are also not
	 * legal.
	 * @param sideA The length of the first side.
	 * @param sideB The length of the second side.
	 * @param sideC The length of the third side.
	 */
	public Triangle(double sideA, double sideB, double sideC) {
		if (isTriangle(sideA, sideB, sideC)) {
			this.sideA = sideA;
			this.sideB = sideB;
			this.sideC = sideC;
		} else {
			this.sideA = 1;
			this.sideB = 1;
			this.sideC = 1;
		}
	}
	
	// Accessors
	/** Return the length of the first side of the Triangle object.
	 * 
	 * @return The length of the first side of the Triangle object.
	 */
	public double getSideA() {
		return sideA;
	}
	
	/** Return the length of the second side of the Triangle object.
	 * 
	 * @return The length of the second side of the Triangle object.
	 */
	public double getSideB() {
		return sideB;
	}
	
	/** Return the length of the third side of the Triangle object.
	 * 
	 * @return The length of the third side of the Triangle object.
	 */
	public double getSideC() {
		return sideC;
	}
	
	/** Convert the three sides of a Triangle to a String. The format will be:
	 * "Triangle(lengthOfSideA, lengthOfSideB, lengthOfSideC)". The Triangle sides will 
	 * be given to three decimal places. For example,
	 * if all sides were of unit length "Triangle(1.000, 1.000, 1.000)" would be
	 * returned.
	 * @return A String that contains the three sides of the implicit Triangle object.
	 */
	public String toString() {
			return "Triangle(" 
				+ FORMATTER.format(sideA) + ", " 
				+ FORMATTER.format(sideB) + ", " 
				+ FORMATTER.format(sideC) + ")";
	}
	
	// Mutators
	/** Modify the length of the first side, if it is legal to do so. See the constructor
	 * for the details of what makes a legal triangle. If the modification would produce
	 * a Triangle object that is not legal, false should be returned and no modification should
	 * be made.
	 * @param sideA The new length of the first side.
	 * @return True if the modification produces a legal Triangle object and false otherwise.
	 */
	public boolean setSideA(double sideA) {
		if (!isTriangle(sideA, this.sideB, this.sideC)) {
			return false;
		}
		this.sideA = sideA;
		return true;
	}
	
	/** Modify the length of the second side, if it is legal to do so. See the constructor
	 * for the details of what makes a legal triangle. If the modification would produce
	 * a Triangle object that is not legal, false should be returned and no modification should
	 * be made.
	 * @param sideB The new length of the second side.
	 * @return True if the modification produces a legal Triangle object and false otherwise.
	 */
	public boolean setSideB(double sideB) {
		if (!isTriangle(this.sideA, sideB, this.sideC)) {
			return false;
		}
		this.sideB = sideB;
		return true;
	}

	/** Modify the length of the third side, if it is legal to do so. See the constructor
	 * for the details of what makes a legal triangle. If the modification would produce
	 * a Triangle object that is not legal, false should be returned and no modification should
	 * be made.
	 * @param sideC The new length of the third side.
	 * @return True if the modification produces a legal Triangle object and false otherwise.
	 */
	public boolean setSideC(double sideC) {
		if (!isTriangle(this.sideA, this.sideB, sideC)) {
			return false;
		}
		this.sideC = sideC;
		return true;
	}
	
	// Class method
	/** Determine whether of not the values can legally be the sides of a Triangle object.
	 * A Triangle is legal when the sum of any two sides is greater than the third side and
	 * all sides are positive. You will notice that this method does not show up in the API
	 * that Javadoc produces.  This is because it is private.
	 * @param a The first side length.
	 * @param b The second side length.
	 * @param c The third side length.
	 * @return True if the side lengths are legal and false otherwise.
	 */
	private static boolean isTriangle(double a, double b, double c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			return false;
		}
		if (a >= b + c || b >= c + a || c >= a + b) {
			return false;
		}
		return true;
	}


}
