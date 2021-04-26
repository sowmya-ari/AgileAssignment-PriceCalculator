import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PriceCalculator {

    public static float calculatePriceWithoutTax(int quantity, float itemPrice){
        return quantity * itemPrice;
    }

    public static float calculatePriceWithTax(float grossPrice, float tax){
        return grossPrice * (1+ (tax/100));
    }

    public static float calculatePriceForSupportedStatesWithTax(String state, Float grossPrice, HashMap<String,Float> stateTaxes){
        if(stateTaxes.containsKey(state)){
            System.out.println("Applied tax percentage is " + stateTaxes.get(state));
            float netPrice = calculatePriceWithTax(grossPrice,stateTaxes.get(state));
            return netPrice;
        }
        return 0;
    }

    public static float calculateDiscountAmount(Float grossPrice){
        float discountPercentage;
        if(grossPrice >= 50000){
            discountPercentage = 15;
        }
        else if(grossPrice >= 10000){
            discountPercentage = 10;
        }
        else if(grossPrice >= 7000){
            discountPercentage = 7;
        }
        else if(grossPrice >= 5000){
            discountPercentage = 5;
        }
        else if(grossPrice > 1000) {
            discountPercentage = 3;
        }
        else {
            discountPercentage = 0;
        }
        System.out.println("You purchase is applicable for discount of percentage " + discountPercentage);
        return (grossPrice * discountPercentage)/100;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter number of items");
        int quantity = scanner.nextInt();
        System.out.println("Please enter price of the item");
        float itemPrice = scanner.nextFloat();
        float grossPrice = calculatePriceWithoutTax(quantity,itemPrice);
        System.out.println("Gross price is " + grossPrice);
        float discountAmount = calculateDiscountAmount(grossPrice);
        System.out.println("Deducted discount amount from gross price " + discountAmount);
        grossPrice = grossPrice - discountAmount;
        System.out.println("Gross price after applying discount amount is " + grossPrice);
        System.out.println("Please enter the state for applying tax");
        String state = scanner.next().toUpperCase();
        List<String> supportedStates = Arrays.asList("UT","NV","TX","AL","CA");
        List<Float> taxes = Arrays.asList(4.85f,6.85f,6.25f,4f,7.25f);
        HashMap<String,Float> stateTaxes = new HashMap<>();
        for(int i = 0; i<supportedStates.size() ; i++){
            stateTaxes.put(supportedStates.get(i),taxes.get(i));
        }
        float netPrice = calculatePriceForSupportedStatesWithTax(state,grossPrice,stateTaxes);
        if(netPrice != 0f) {
            System.out.println("Net price is " + netPrice);
            return;
        }
        System.out.println("Entered state is not supported for price calculations " + state);
    }
}
