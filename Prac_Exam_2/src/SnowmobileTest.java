import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SnowmobileTest {
    private final double weight = 2.1;
    private final int gears = 2;
    private Snowmobile snowmobile;

    @Before
    public void setUp() throws Exception {
        snowmobile = new Snowmobile(weight, gears);
        assertNotNull(snowmobile);
    }

    @Test
    public void testToString() {
        String expected = "{ gears='2'}";
        String actual = snowmobile.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testToString1() {
        try {
            int gears = 1;
            Snowmobile b = new Snowmobile(weight, gears);
            String expected = "{ gear='1'}";
            String actual = b.toString();
            assertEquals(expected, actual);
        } catch (Exception e) {
            System.out.println("Exception should not be thrown");
        }
    }

    @Test
    public void testIsBetter() {
        try {
            int newGears = gears + 1;
            Snowmobile b = new Snowmobile(weight, newGears);
            assertTrue(b.isBetter(snowmobile));
            assertFalse(snowmobile.isBetter(b));

            double newWeight = weight + 1.0;
            Snowmobile bw= new Snowmobile(newWeight, gears);
            assertFalse(bw.isBetter(snowmobile));
            assertTrue(snowmobile.isBetter(bw));

            newWeight = weight;
            bw= new Snowmobile(newWeight, gears);
            assertFalse(bw.isBetter(snowmobile));

        } catch ( WeightException|GearsException e) {
            System.out.println(e);
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void testIsWorst() {
        try {
            // same weight,  snowmobile with less gears is worst
            int newGears = gears + 1;
            Snowmobile b = new Snowmobile(weight, newGears);
            assertFalse(b.isWorst(snowmobile));
            assertTrue(snowmobile.isWorst(b));

            // same number of gears, heavier snowmobile is worst
            double newWeight = weight + 1.0;
            Snowmobile bw= new Snowmobile(newWeight, gears);
            assertTrue(bw.isWorst(snowmobile));
            assertFalse(snowmobile.isWorst(bw));

            newWeight = weight;
            bw= new Snowmobile(newWeight, gears);
            assertFalse(bw.isWorst(snowmobile));
        } catch ( WeightException|GearsException e) {
            System.out.println(e);
            fail("Exception should not be thrown");
        }
    }

    @Test
    public void testNeedLicense() {
        assertFalse(snowmobile.needLicense());
    }
    @Test
    public void testGetGears() {
        int expected = gears;
        int actual = snowmobile.getGears();
        assertEquals(expected, actual);
    }

    @Test
    public void testSetGears() {
        try {
            Snowmobile b = new Snowmobile(2., 2);

            int expected = 3;
            b.setGears(expected);
            int actual = b.getGears();
            assertEquals(expected, actual);

        } catch (GearsException|WeightException e) {
            fail("Should not throw an exception"); 
        }
    }

    @Test
    public void testSetGearsWithException() {
        try {
            Snowmobile b = new Snowmobile(2., -2);
            fail("Exception should be thrown");
        } catch (GearsException e) {
            assertTrue(true);
        } catch (WeightException e) {
            fail("Weight exception should not be thrown");
        }
    }

    @Test
    public void testCompareTo() {
        try {
            Snowmobile b2 = new Snowmobile(weight, gears);
            Snowmobile b3 = new Snowmobile(weight, gears + 1);
            int actual = b3.compareTo(b2);
            int expected = 1;
            assertEquals(expected, actual);

            actual = b2.compareTo(b3);
            expected = -1;
            assertEquals(expected, actual);
        } catch (WeightException | GearsException e) {
            System.out.println(e);
        }

    }

    @Test
    public void testMachine() {
        try {
            Snowmobile b = new Snowmobile(2., 3);
            assertNotNull(b);
        } catch (WeightException | GearsException e) {
            System.out.println(e);
            fail("Exception was thrown");
        }
    }

    @Test
    public void testGetWeight() {
        double actual = snowmobile.getWeight();
        double expected = weight;
        double delta = 0.001;
        assertEquals(expected, actual, delta);
    }

    @Test
    public void testSetWeight() {
        try {
        double expected = 3.33;
        snowmobile.setWeight(expected);
        double actual = snowmobile.getWeight();
        double delta = 0.001;
        assertEquals(expected, actual, delta);
        } catch (WeightException e){
            fail("Weight excpetion should not be thrown");
        }
    }

}