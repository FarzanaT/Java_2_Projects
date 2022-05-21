package mockExam;


public class EmptyArrayException extends Exception {
  private static final long serialVersionUID = 42L;

	public EmptyArrayException() {
		System.out.println("Array reference is null");
	}

}
