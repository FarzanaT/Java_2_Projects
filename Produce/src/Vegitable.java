
public class Vegitable extends Produce {
		protected double pricePerPound;
		protected double numberOfPounds;
		
		public double getPricePerPound() {
			return pricePerPound;
		}
		public void setPricePerPound(double pricePerPound) {
			this.pricePerPound = pricePerPound;
		}
		public double getNumberOfPounds() {
			return numberOfPounds;
		}
		public void setNumberOfPounds(double numberOfPounds) {
			this.numberOfPounds = numberOfPounds;
		}
		public Vegitable() {
			super();
			pricePerPound = 10.0;
		}
		public double calculatePrice() {
			return getPricePerPound() * getNumberOfPounds();
			
		}
}
