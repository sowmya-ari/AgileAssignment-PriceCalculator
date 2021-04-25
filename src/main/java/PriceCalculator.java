import java.util.Scanner;

public class PriceCalculator {

    public static float calculatePriceWithoutTax(int quantity, float itemPrice){
        return quantity * itemPrice;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter number of items");
        int quantity = scanner.nextInt();
        System.out.println("Please enter price of the item");
        float itemPrice = scanner.nextFloat();
        float totalPrice = calculatePriceWithoutTax(quantity,itemPrice);
        System.out.println("Total price is " + totalPrice);
    }
}
