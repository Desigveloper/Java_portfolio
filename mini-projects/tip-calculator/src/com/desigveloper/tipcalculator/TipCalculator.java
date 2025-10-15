package com.desigveloper.tipcalculator;

import java.util.Scanner;

public class TipCalculator {

    public void displayOutput(double tip, double totalAmount) {
        System.out.format("Tip: $%.2f\n", tip);
        System.out.format("Total amount: $%.2f\n", totalAmount);
    }

    public double getValidNumber(Scanner sc, String inputType) {
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
}