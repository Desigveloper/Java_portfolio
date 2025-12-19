package tollkeeper;

import java.util.Scanner;

public class App {
    private static Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        String vehicleType;
        double amount = 0;

        System.out.print("Enter your vehicle type using letters (C: Car, T: Track, M: Motor and B: Bike): ");
        vehicleType = cin.nextLine();

        if (vehicleType.equalsIgnoreCase("t")) {
            amount = 10;
        }
        else if (vehicleType.equalsIgnoreCase("c")) {
            amount = 5;
        }
        else if (vehicleType.equalsIgnoreCase("m")) {
            amount = 3;
        } else if (vehicleType.equalsIgnoreCase("b")) {
            amount = 1;
        } else {
            System.out.println("Invalid vehicle type");
            System.exit(0);
        }

        System.out.printf("For %s, you need to pay $%.2f\n", vehicleType.toUpperCase(), amount);
    }
}
