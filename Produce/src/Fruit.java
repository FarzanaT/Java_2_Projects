
public class Fruit extends Produce{
	protected double pricePerItem;
	protected double numberOfItems;
	
	public Fruit() {
		
	}
	public double getPricePerItem() {
		return pricePerItem;
	}
	public void setPricePerItem(double pricePerItem) {
		this.pricePerItem = pricePerItem;
	}
	public double getNumberOfItems() {
		return numberOfItems;
	}
	public void setNumberOfItems(double numberOfItems) {
		this.numberOfItems = numberOfItems;
	}
	public double calculatePrice() {
		return pricePerItem * numberOfItems;
	}
	

}
