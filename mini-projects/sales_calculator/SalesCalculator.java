package sales_calculator;

import java.util.Scanner;

public class SalesCalculator {
    private static final Scanner sc = new Scanner(System.in);
    private static final double VAT = 0.19; // 19% value-added tax rate
    public static void main(String[] args) {
        double originalPrice, discountRate, tax, discount, finalPrice;

        System.out.print("Enter original price of product: ");
        originalPrice = Double.parseDouble(sc.nextLine());

        tax = originalPrice * VAT;

        finalPrice = originalPrice + tax;

        System.out.print("Enter discount rate (in %) offered: ");
        discountRate = Double.parseDouble(sc.nextLine()) / 100;

        discount = originalPrice * discountRate;

        finalPrice -= discount;

        System.out.printf("\nOriginal Price: $%.2f\n", originalPrice);
        System.out.printf("Tax (%.2f%%): %.2f\n", VAT * 100, tax);
        System.out.printf("Discount (%.2f%%): %.2f\n", discountRate * 100, discount);
        System.out.printf("Final Price after Discount and Tax: $%.2f\n", finalPrice);
    }
}
