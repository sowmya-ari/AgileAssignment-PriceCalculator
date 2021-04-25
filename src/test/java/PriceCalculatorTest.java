import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PriceCalculatorTest {
    private PriceCalculator priceCalculator;

    @Before
    public void setUp(){
        priceCalculator = new PriceCalculator();
    }

    @Test
    public void testPriceCalculator () {
        float itemPrice = 10;
        int quantity = 5;
        float totalPriceWithoutTax = priceCalculator.calculatePriceWithoutTax(quantity,itemPrice);
        assertEquals(totalPriceWithoutTax,50);
    }
}
