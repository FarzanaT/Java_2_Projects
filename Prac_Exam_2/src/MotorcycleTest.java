import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MotorcycleTest {
    private double weight = 1.1;
    private double price = 1000.99;
    private Motorcycle motorcyle;

    @Before
    public void setUp() throws Exception {
        try {
            motorcyle = new Motorcycle(weight, price);
        } catch (WeightException | PriceException e) {
            System.out.println(e);
        }
    }

    @Test
    public void testToString() {
        String actual = motorcyle.toString();
        String expected = "{ weight='1.1', price='1000.99'}";
        assertEquals(expected, actual);
    }

    @Test
    public void testIsBetter() {
        try {
            // better motorcyle is more expensive
            // if the price is the same, it is 
            // based on Machine isBetter
            double newPrice = price + 100.0;
            Motorcycle betterMotorcycle = new Motorcycle(weight, newPrice);
            assertTrue(betterMotorcycle.isBetter(motorcyle));
            assertFalse(motorcyle.isBetter(betterMotorcycle));
        } catch (PriceException | WeightException e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void testIsWorst() {
        try {
            // worst motorcyle is less expensive
            // if the price is the same, it is 
            // based on Machine isWorst
            double newPrice = price + 100.0;
            Motorcycle betterMotorcycle = new Motorcycle(weight, newPrice);
            assertTrue(motorcyle.isWorst(betterMotorcycle));
            assertFalse(betterMotorcycle.isWorst(motorcyle));
        } catch (PriceException | WeightException e) {
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void testNeedLicense() {
        assertTrue(motorcyle.needLicense());
    }

    @Test
    public void testGetPrice() {
        double expected = price;
        double actual = motorcyle.getPrice();
        final double delta = 0.0001;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void testSetPrice() {
        try {
            double expected = 999.99;
            motorcyle.setPrice(expected);
            double actual = motorcyle.getPrice();
            final double delta = 0.0001;
            assertEquals(expected, actual, delta);

        } catch (PriceException e) {
            fail("Price exception should not be thrown");
        }
    }

    @Test
    public void testCompareTo() {
        try {
            double newPrice = price + 100.0;
            Motorcycle c = new Motorcycle(10.0, newPrice);

            int actual = c.compareTo(motorcyle);
            int expected = 1;

            assertEquals(expected, actual);

        } catch (PriceException | WeightException e) {
            fail("Should not throw an exception");
        }
    }

    @Test
    public void testGetWeight() {
        double actual = motorcyle.getWeight();
        double expected = weight;
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testSetWeight() {
        try {
            double newWeight = weight + 100.0;
            Motorcycle c = new Motorcycle(newWeight, price);

            double actual = c.getWeight();
            double expected = newWeight;

            assertEquals(expected, actual, 0.001);

        } catch (PriceException | WeightException e) {
            fail("Should not throw an exception");
        }
    }
}