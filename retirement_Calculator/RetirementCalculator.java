package retirement_Calculator;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * A program that takes current age and expected retirement age of the user 
 * determines how many years they have left until retirement
 * and the year they can retire.
*/

public class RetirementCalculator {
    private static int calculateYearsLeft(int currentAge, int expectedRetirementAge) {
        return expectedRetirementAge - currentAge;
    }

    private static int getValidInput(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Enter a valid number");
            sc.next();
        }

        return sc.nextInt();
    }

    private static void displayYearsAndDate(int yearsLeft, LocalDate currentDate) {
        int currentYear = currentDate.getYear();
        int retirementYear = currentYear + yearsLeft;

        System.out.format("You have %d left until you can retire.\n",  yearsLeft );
        System.out.format("It's %d, so you can retire in %d.\n", currentYear, retirementYear);
    }

    public static void main(String[] args) {
        System.out.print("What is your current age? ");
        int currentAge = getValidInput(new Scanner(System.in));

        System.out.print("At what age would you want to retire? ");
        int expectedAge = getValidInput(new Scanner(System.in));

        int yearsLeft = calculateYearsLeft(currentAge, expectedAge);

        displayYearsAndDate(yearsLeft, LocalDate.now());

    }
}
