
public class Driver {
	public static void main (String [] args) {
		Produce p = new Produce ();
		double price = p.calculatePrice();
		System.out.println(price);
		
		Produce v = new Vegitable();
		v.setNumberOfPounds(9.0);
		v.setPricePerPound(2.0);
		price = v.calculatePrice();
		System.out.println(price);
		
		Produce z = v;  //upcasting
		System.out.println("Produce Ref: " + z.calculatePrice());
		
		Fruit f = new Fruit();
		f.setNumberOfItems(10);
		f.setPricePerItem(9.0);
		
		Fruit watermelon = new Fruit();
		watermelon.setNumberOfItems(1);
		watermelon.setNumberOfItems(9.50);
		
		Produce[] shoppingCart = new Produce[4];
		
		
		
		shoppingCart[0] = watermelon;  //upcasting for 
		shoppingCart[1] = watermelon;
		shoppingCart[2] = v;
		shoppingCart[3] = z;
		
		double total = 0;
		for(int i = 0; i< 4; ++i) {
			total = total + shoppingCart[i].calculatePrice();
			
			if(shoppingCart[i] instanceof Vegitable) {
				System.out.println("it may be ");
			}
			
			Fruit u = (Fruit)shoppingCart[0];   //downcasting 
			u.getNumberOfItems();
			
			
					}
		
		Produce a  = new Fruit();	
		((Fruit)a).setNumberOfItems(9);
		
		Vegitable b = (Vegitable)a;
		b.setNumberOfPounds(2.0);
		b.setPricePerPound(2.0);
		System.out.println(b.calculatePrice());
		
	}

}
