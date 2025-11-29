package salestax;

import java.util.Scanner;

public class TaxCalculator {
    private static final double VAT = 0.19; // value-added tax rate of 19%
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        double price, tax, totalPrice;
        System.out.print("Enter the price of the product: ");
        price = Double.parseDouble(sc.nextLine());

        tax = price * VAT;
        totalPrice = price + tax;

        System.out.printf("\nPrice: GHc%.2f\n", price);
        System.out.printf("VAT (19%%): %.2f\n", tax);
        System.out.printf("Total Price: GHc%.2f\n", totalPrice);
    }
}
