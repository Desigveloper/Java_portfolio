package discount;

import java.util.Scanner;

public class DiscountCalculator {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        double originalPrice, discountRate, discountAmount, finalPrice;
        System.out.print("Enter the original price of the product: ");
        originalPrice = Double.parseDouble(sc.nextLine());

        System.out.print("Enter the discount rate (in %): ");
        discountRate = Double.parseDouble(sc.nextLine()) / 100;

        discountAmount = originalPrice * discountRate;
        finalPrice = originalPrice - discountAmount;

        System.out.printf("\nOriginal Price: $%.2f\n", originalPrice);
        System.out.printf("Discount (%.2f%%): $%.2f\n", discountRate * 100, discountAmount);
        System.out.printf("Final Price after Discount: $%.2f\n", finalPrice);
    }
}
