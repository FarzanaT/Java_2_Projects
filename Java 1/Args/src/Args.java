
public class Args {

private static int counter = -1; //class variable

public Args() {
	counter = getCounter() + 1;
	likeIndex = getLikeIndex() + 1;
	
	int x = 0;  //object variable - works differently than local variable 
	//System.out.println (x); 
	
	
}

public int counter() {
	return getCounter();
}


@Override
public String toString() {
	return "counter" + getCounter();
}

private int likeIndex = 1_000_000; //object variable
private String name;
private boolean iamsmart;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println ("check");
//		for (int i = 0; i<= args.length; i++) {
//			System.out.println ("Argument is " + i + " " + args[i]);
//		}
		
		for (int j = 0; j<7; j++) {
			var a = new Args();
			System.out.println ("index " + a.getLikeIndex());
		}

	}


	public int getLikeIndex() {
		return likeIndex;
	}

	public static int getCounter() {
		return counter;
	}

}
