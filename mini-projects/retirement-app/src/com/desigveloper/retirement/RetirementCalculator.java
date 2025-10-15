package com.desigveloper.retirement;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * A program that takes current age and expected retirement age of the user 
 * determines how many years they have left until retirement
 * and the year they can retire.
*/

public class RetirementCalculator {
    public int calculateYearsLeft(int currentAge, int expectedRetirementAge) {
        return expectedRetirementAge - currentAge;
    }

    public int getValidInput(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Enter a valid number");
            sc.next();
        }

        return sc.nextInt();
    }

    public void displayYearsAndDate(int yearsLeft, LocalDate currentDate) {
        int currentYear = currentDate.getYear();
        int retirementYear = currentYear + yearsLeft;

        if (calculateYearsLeft(currentYear, retirementYear) < 0) {
            System.out.println("You are already retired");
        } else {
            System.out.format("You have %d left until you can retire.\n",  yearsLeft );
            System.out.format("It's %d, so you can retire in %d.\n", currentYear, retirementYear);
        }
    }
}
