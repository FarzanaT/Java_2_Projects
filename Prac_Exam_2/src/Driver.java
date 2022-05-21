public class Driver {
   public static void main(String[] args) throws PriceException, WeightException {
         double weight = 100.0;
         double price = 1000.0;
         Motorcycle cycle = new Motorcycle(weight, price);
         double wx = cycle.getWeight();
      
   }
}