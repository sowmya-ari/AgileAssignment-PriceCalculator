import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PriceCalculatorTest {
    private PriceCalculator priceCalculator;
    float itemPrice = 10;
    int quantity = 5;
    int tax = 3;

    @Before
    public void setUp(){
        priceCalculator = new PriceCalculator();
    }

    @Test
    public void totalPriceCalculatorWithoutTax() {
        float totalPriceWithoutTax = priceCalculator.calculatePriceWithoutTax(quantity,itemPrice);
        assertEquals(totalPriceWithoutTax,50f,0);
    }

    @Test
    public void totalPriceCalculatorWithTax() {
        float actualPriceWithTax = (float) (50 * (1+0.03));
        float grossPrice = 50;
        float totalPriceWithTax = priceCalculator.calculatePriceWithTax(grossPrice,tax);
        assertEquals(totalPriceWithTax,actualPriceWithTax,0);
    }
}
