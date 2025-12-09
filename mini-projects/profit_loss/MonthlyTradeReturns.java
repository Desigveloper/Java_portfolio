package profit_loss;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;

public class MonthlyTradeReturns {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        final double costOfHoverboard = 150;
        final double sellingPrice = 250;
        final double insurancePerEmployee = 1000;

        int quantitySold, numberOfEmployees;
        int monthValue = LocalDate.now().getMonthValue();
        Month month = Month.of(monthValue - 1);
        
        System.out.print("Enter the quantity sold for the of " + month + ": ");
        quantitySold = Integer.parseInt(sc.nextLine());

        System.out.print("Enter number of employees: ");
        numberOfEmployees = Integer.parseInt(sc.nextLine());

        if (quantitySold < 0 || numberOfEmployees < 1) {
            System.out.println("Sorry quantity sold or number 0f employer cannot be negative. Try again!");
            System.exit(0);
        }

        double returns = (sellingPrice * quantitySold) - (costOfHoverboard * quantitySold) 
                - (insurancePerEmployee * numberOfEmployees);

        if (returns > 0) {
            System.out.printf("Profit: $%.2f\n", returns);
        }
        else if (returns < 0) {
            System.out.printf("Loss: $%.2f\n", returns * (-1));
        } else {
            System.out.println("Broke even");
        }


    }
}
