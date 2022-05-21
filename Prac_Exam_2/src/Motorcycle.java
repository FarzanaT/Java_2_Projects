public class Motorcycle extends Machine implements Comparable<Motorcycle>{
	
	private double price;
    public Motorcycle(double weight, double price)throws PriceException, WeightException {
		super(weight);
		if(price < 0) {
    		throw new PriceException("Price exception should be thrown");
    	}
		this.price = price;
		// TODO Auto-generated constructor stub
	}

	

   /*  FIXME
    */
//    public Motorcycle(double weight, double price) 
//    }
//    */
//	 public Motorcycle(double weight, double price) {
//		 
//	 }
	 


    public double getPrice() {
        return this.price; 
    }

   // FIXME - if price is < 0, throw an exception
   /*
    public void setPrice(double price) {
    }
    */
    public void setPrice(double price) throws PriceException {
    	if(price < 0) {
    		throw new PriceException("Price exception should be thrown");
    	}
    	this.price = price;
    }

    @Override
    public String toString() {
       // FIXME
        String str = "{ weight='" + this.getWeight() + "', price='" + this.getPrice() + "'}";
        
        // I would keep it
       // str = str.replace('}', ',');
        
        // FIXME
        return str;

    }
    /* 
        Compare motorcycles based on their price, 
        cheaper has lower priority.
        same return 0
        more expensive has higher priority
    */
    @Override
    public int compareTo( Motorcycle c) { //DONE
        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;
        if(c.getPrice() > this.getPrice()) {
        	return BEFORE;
        }
        else if(c.getPrice() < this.getPrice()) {
        	return AFTER;
        }
        else if(c.getPrice() == this.getPrice()) {
        	return EQUAL;
        }
      //    FIXME
        return -999;
    }


    /*
        compare motorcycles based on their price
        if price is the same, 
        compare based on weight - as implemented by the superclass
    */
    @Override
    public boolean isBetter(Object o) {
      // FIXME
    	Motorcycle c = (Motorcycle)o;
    	
    		int comp = c.compareTo(this);
    		if(comp == 1) {
    			return true;
    		}
    		else if(comp == 0) {
    			c.isBetter(this);
    		}
    		
    		  	
        return false;
    }

    /*
        compare motorcycles based on their price
        if price is the same, compare 
            based on weight - as implemented by the superclass
    */
    @Override
    public boolean isWorst(Object o) {
      // FIXME
    	Motorcycle c = (Motorcycle)o;
    	if(c.getPrice() != getPrice() && c.getPrice() < getPrice()) { //not equal
    		return true;
    	}
    	if(c.getPrice() == getPrice() && c.getWeight() > this.getWeight()) {
    		return true;
    	}
    	
        return false;
    }

   //  FIXME - DOES NEED A LICENSE
    @Override
    public boolean needLicense() {
        return true;
    }

    public static void main(String... args){
    	try {
        Motorcycle c1 = new Motorcycle(1., 200.0);
		Motorcycle c2 = new Motorcycle(1., 500.0);
		System.out.println(c1.compareTo(c2));

		Motorcycle c3 = new Motorcycle(1., 500.000001);
		System.out.println(c3.compareTo(c2));

		Motorcycle c4 = new Motorcycle(1.,  -1.0);
		Motorcycle c5 = new Motorcycle(1., 1.0);
		System.out.println(c4.compareTo(c5));
    	}
    	catch(PriceException | WeightException e) {
    		System.out.println(e);
    	}
    }
    
}