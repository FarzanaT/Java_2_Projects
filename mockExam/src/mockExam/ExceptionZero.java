package mockExam;



class ExceptionZero {
	
	public static String divideMethod(int a, int b)  {		
	// Modify this method to catch appropriate exception and return exception e.toString()

try{
   	int result = a/b;
}
	 catch (ArithmaticException e){
	    return e.toString();
	 }
	
		
		// don't modify the return statement
		return String.valueOf(result);

	}
	
	public static void main(String[] args) {		
		
		System.out.println(divideMethod(20, 0));
		
	}
}