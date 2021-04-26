import java.util.Scanner;

public class PriceCalculator {

    public static float calculatePriceWithoutTax(int quantity, float itemPrice){
        return quantity * itemPrice;
    }

    public static float calculatePriceWithTax(float grossPrice, float tax){
        return grossPrice * (1+ (tax/100));
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter number of items");
        int quantity = scanner.nextInt();
        System.out.println("Please enter price of the item");
        float itemPrice = scanner.nextFloat();
        float grossPrice = calculatePriceWithoutTax(quantity,itemPrice);
        System.out.println("Gross price is " + grossPrice);
        float fixedTax = 3;
        System.out.println("Apply fixed tax of " + fixedTax);
        float netPrice = calculatePriceWithTax(grossPrice,fixedTax);
        System.out.println("Net price is " + netPrice);
    }
}
