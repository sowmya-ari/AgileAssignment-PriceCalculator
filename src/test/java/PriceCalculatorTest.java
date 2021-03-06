import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

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
    public void testTotalPriceCalculationWithoutTax() {
        float totalPriceWithoutTax = priceCalculator.calculatePriceWithoutTax(quantity,itemPrice);
        assertEquals(totalPriceWithoutTax,50f,0);
    }

    @Test
    public void testTotalPriceCalculationWithTax() {
        float actualPriceWithTax = (float) (50 * (1+0.03));
        float grossPrice = 50;
        float totalPriceWithTax = priceCalculator.calculatePriceWithTax(grossPrice,tax);
        assertEquals(totalPriceWithTax,actualPriceWithTax,0);
    }

    @Test
    public void testTotalPriceCalculationForSupportedStateWithTax() {
        float actualPriceWithTax = (float) (50 * (1+(4.85/100)));
        String state = "UT";
        HashMap<String,Float> stateTaxes = new HashMap<>();
        stateTaxes.put(state,4.85f);
        float totalPriceWithTax = priceCalculator.calculatePriceForSupportedStatesWithTax(state,50f,stateTaxes);
        assertEquals(totalPriceWithTax,actualPriceWithTax,3);
    }

    @Test
    public void testTotalPriceCalculationForUnSupportedState() {
        String state = "UTN";
        HashMap<String,Float> stateTaxes = new HashMap<>();
        stateTaxes.put("UN",4.85f);
        float totalPriceWithTax = priceCalculator.calculatePriceForSupportedStatesWithTax(state,50f,stateTaxes);
        assertEquals(totalPriceWithTax,0,0);
    }

    @Test
    public void testWhetherApplicableDiscountPercentageIsApplyingBasedOnGrossAmount() {
        // Gross amount is greater than 1000 - Discount percentage is 3
        float grossPrice = 1001;
        float discountPercentage = 3;
        float actualDiscountAmount = grossPrice * (discountPercentage/100);
        float calculatedDiscountAmount = priceCalculator.calculateDiscountAmount(grossPrice);
        assertEquals(calculatedDiscountAmount,actualDiscountAmount,3);

        //Gross amount is greater than or equal to 50000 - Discount percentage is 15
        grossPrice = 50000;
        discountPercentage = 15;
        actualDiscountAmount = grossPrice * (discountPercentage/100);
        calculatedDiscountAmount = priceCalculator.calculateDiscountAmount(grossPrice);
        assertEquals(calculatedDiscountAmount,actualDiscountAmount,3);

        //Gross amount is greater than or equal to 10000 but less than 50000 - Discount percentage is 10
        grossPrice = 10005;
        discountPercentage = 10;
        actualDiscountAmount = grossPrice * (discountPercentage/100);
        calculatedDiscountAmount = priceCalculator.calculateDiscountAmount(grossPrice);
        assertEquals(calculatedDiscountAmount,actualDiscountAmount,3);


        //Gross amount is greater than or equal to 7000 but less than 10000 - Discount percentage is 7
        grossPrice = 8000;
        discountPercentage = 7;
        actualDiscountAmount = grossPrice * (discountPercentage/100);
        calculatedDiscountAmount = priceCalculator.calculateDiscountAmount(grossPrice);
        assertEquals(calculatedDiscountAmount,actualDiscountAmount,3);

        //Gross amount is greater than or equal to 5000 but less than 7000 - Discount percentage is 5
        grossPrice = 6000;
        discountPercentage = 5;
        actualDiscountAmount = grossPrice * (discountPercentage/100);
        calculatedDiscountAmount = priceCalculator.calculateDiscountAmount(grossPrice);
        assertEquals(calculatedDiscountAmount,actualDiscountAmount,3);
    }

    @Test
    public void testTotalPriceCalculationsWithDiscountForUnApplicableGrossAmount() {
        float grossPrice = 50;
        float actualDiscountAmount = 0;
        float calculatedDiscountAmount = priceCalculator.calculateDiscountAmount(grossPrice);
        assertEquals(calculatedDiscountAmount,actualDiscountAmount,0);
    }
}
