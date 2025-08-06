package Simple_Tip_Calculator;

import java.util.Scanner;

public class TipCalculator {

    private static void displayOutput(double tip, double totalAmount) {
        System.out.format("Tip: $%.2f\n", tip);
        System.out.format("Total amount: $%.2f\n", totalAmount);
    }

    private static double getValidNumber(Scanner sc, String inputType) {
        boolean notValid = true;
        double getValidNumber = 0;

        while (notValid) {
            if (!sc.hasNextDouble()) {
                System.out.print("Enter a valid number for the " + inputType + ": ");
                sc.next(); // Clear invalid input
            } else {
                getValidNumber = sc.nextDouble();
                if (getValidNumber <= 0) {
                    System.out.print("Enter a valid number for the " + inputType + ": ");
                } else {
                    notValid = false;
                }
            }
        }

        return getValidNumber;
    }
    public static void main(String[] args) {
        double billAmount;
        double tipRate;
        double tip;
        double totalAmount;

        System.out.print("What is the bill amount: ");
        billAmount = getValidNumber(new Scanner(System.in), "bill amount");
        

        System.out.print("What is the tip rate: ");
        tipRate = getValidNumber(new Scanner(System.in), "tip rate");
        

        tip = billAmount * (tipRate / 100);
        totalAmount = billAmount + tip;

        displayOutput(tip, totalAmount);

    }
}