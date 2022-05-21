public class Snowmobile extends Machine implements Comparable<Snowmobile>{
    private int gears = 1;
    private double weight;

   /* FIXME
    public Snowmobile(double weight, int gears) {
    }
    */
    public Snowmobile(double weight, int gears2) throws WeightException, GearsException {
    	super(weight);
    	if(gears2 < 1) {
    		throw new GearsException("Error");
    	}
    	this.gears = gears2;
    }
    
    


	public int getGears() {
        return this.gears; // FIXME
    }

    public void setGears(int gears) throws GearsException,  WeightException{
         // FIXME throw GearsExcetion if number is less than 1
    	if(gears < 1) {
    		throw new GearsException("Should not throw an exception");
    	}
//    	if(weight <= 0) {
//    		throw new WeightException("Should not throw an exception");
//    	}
    	this.gears = gears;
    }

    @Override
    public String toString() {
       // FIXME  - look at the unit test, you have to differentiate between 1 and more gears
    	String str = "";
    	if (this.gears == 1) {
    		str = "{ gear='" + this.gears + "'}";
    	}
    	else {
    	 str = "{ gears='" + this.gears + "'}";
    	}
    	return str;  // this String will fail...
    }
    
    

    @Override
    public int compareTo( Snowmobile c) {

        final int BEFORE = -1;
        final int EQUAL = 0;
        final int AFTER = 1;
         // FIXME less gears means that we return BEFORE, and so on...
        if(this.getGears() < c.getGears()) {
        	return BEFORE;
        }
        else if(this.getGears() > c.getGears()) {
        	return AFTER;
        }
        return EQUAL;
    }

    /*
        Snowmobile with more gears is better
        If they have the same number of gears, lighter (weight) Snowmobile is better
    */
    @Override
    public boolean isBetter(Object o) {
      // FIXME
    	Snowmobile s =  (Snowmobile) o;
    	
    	int comp = this.compareTo(s);
    	if(comp == 1) {
    		return true;
    	}
    	if(comp < 0) {
    		return false;
    	}
    	if(comp == 0) {
    		if(this.getWeight() < s.getWeight()) {
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	
        return false;
    }

    /*
        Snowmobile with less gears is worst
        If they have the same number of gears, lighter Snowmobile is better
    */
    @Override
    public boolean isWorst(Object o) {
      // FIXME
    	Snowmobile s = (Snowmobile) o;
    	
    	int comp = this.compareTo(s);
    	
    	if(comp < 0) {
    		return true;
    	}
    	if (comp == 1) {
    		return false;
    	}
    	if(comp == 0) {
    		if(this.getWeight() > s.getWeight()) {
    			return true;
    		}
    		return false;
    	}

       return false;
    }

    @Override
    public boolean needLicense() {

        return false;
    }
    

    public static void main(String... args) {
        try {
            Snowmobile c1 = new Snowmobile(200.0, 1);
            Snowmobile c2 = new Snowmobile(500.0, 2);
            System.out.println(c1.compareTo(c2));
        } catch (WeightException|GearsException e)  {
            System.out.println(e);
        }

        try {

            Snowmobile c2 = new Snowmobile(500.0, 2);
            Snowmobile c3 = new Snowmobile(500.000001, 3);
            System.out.println(c3.compareTo(c2));
        } catch (WeightException|GearsException e) {
            System.out.println(e);
        }

        try {
            Snowmobile c4 = new Snowmobile(-1.0, 2);
            Snowmobile c5 = new Snowmobile(1.0, 1);
            System.out.println(c4.compareTo(c5));
        } catch (WeightException|GearsException e) {
        	//e.printStackTrace();
            System.out.println(e);
        }

        try {
            Snowmobile c4 = new Snowmobile(1.0, 2);
            Snowmobile c5 = new Snowmobile(1.0, -1);
            System.out.println(c4.compareTo(c5));
        } catch (WeightException|GearsException e) {
            System.out.println(e);
        }
    }
}