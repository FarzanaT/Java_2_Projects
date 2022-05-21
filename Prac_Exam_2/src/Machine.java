public abstract class Machine implements Valuator{
    private double weight;
    private int x;
  
    public Machine (double weight) {
    	this.weight = weight;
    
    }
 

    @Override
    public String toString() {
        return "{ weight= " + "'" + this.weight + "'" ;// FIXME
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) throws WeightException {
       // FIXME - REMEMBER throw and exception if the weight passed is <= 0
    	if(weight <= 0) {
    		throw new WeightException("Exception should be thrown");
    	}
    	this.weight = weight;

    }

    /*
    Machine with a lower weight is better
    */
    public boolean isBetter(Object o){
    	Machine m = (Machine)o;
    	if(m.getWeight() <= getWeight()) {
    		return true;
    	}
   
        return false;
    }

    /*
    Machine with a higher weight is worst
    */
    public boolean isWorst(Object o){
    	Machine m = (Machine)o;
    	if(m.getWeight() > getWeight()) {
    		return true;
    	}
      
        return false;
    }


    public abstract boolean needLicense();
}