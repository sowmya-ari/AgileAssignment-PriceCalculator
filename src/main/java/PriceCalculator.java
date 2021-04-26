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

    public static float calculatePriceForSupportedStatesWithTax(String state, HashMap stateTaxes){
        return 0;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter number of items");
        int quantity = scanner.nextInt();
        System.out.println("Please enter price of the item");
        float itemPrice = scanner.nextFloat();
        float grossPrice = calculatePriceWithoutTax(quantity,itemPrice);
        System.out.println("Gross price is " + grossPrice);
        System.out.println("Please enter the state");
        String state = scanner.next().toUpperCase();
        List<String> supportedStates = Arrays.asList("UT");
        List<Float> taxes = Arrays.asList(4.85f);
        HashMap<String,Float> stateTaxes = new HashMap<>();
        for(int i = 0; i<supportedStates.size() ; i++){
            stateTaxes.put(supportedStates.get(i),taxes.get(i));
        }
        float netPrice = calculatePriceForSupportedStatesWithTax(state,stateTaxes);
        System.out.println("Net price is " + netPrice);
    }
}
