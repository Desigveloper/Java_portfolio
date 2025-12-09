package currency_convertor;

import java.util.Scanner;

public class Convertor {
    private static final Scanner sc = new Scanner(System.in);

    static void showMenu() {
        System.out.println("\n=== CURRENCY CONVERTOR ====");
        System.out.println("1. Convert USD to Euro (EUR)");
        System.out.println("2) Convert USD to British Pound Sterling (GBP)");
        System.out.println("3) Convert USD to Japanese Yen (JPY)");
        System.out.println("4) Convert USD to Canadian Dollar (CAD)");
    }
    
    static double convertCurrency(int choice, double amount) {
        double convertedAmount = switch(choice) {
            case 1 -> amount * 0.94;
            case 2 -> amount * 0.81;
            case 3 -> amount * 149.11;
            case 4 -> amount * 1.36;
            default -> 0;
        };

        return convertedAmount;
    }

    public static void main(String[] args) {
        int choice;
        double amount;

        showMenu();

        System.out.print("Choose an option: ");
        choice = Integer.parseInt(sc.nextLine());

        System.out.print("Enter the amount: ");
        amount = Double.parseDouble(sc.nextLine());

        double convertedAmount = convertCurrency(choice, amount);

        switch (choice) {
            case 1: System.out.printf("$%.2f = EUR €%.2f\n", amount, convertedAmount);
                break;
            case 2: System.out.printf("$%.2f = GBP £%.2f\n", amount, convertedAmount);
                break;
            case 3: System.out.printf("$%.2f = JPY ¥%.2f\n", amount, convertedAmount);
                break;
            case 4: System.out.printf("$%.2f = CAD $%.2f\n", amount, convertedAmount);
                break;
        }
    }
}
