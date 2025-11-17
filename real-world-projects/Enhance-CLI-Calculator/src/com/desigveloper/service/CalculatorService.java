package com.desigveloper.service;

import java.util.Scanner;

public class CalculatorService {
    private Scanner scanner = new Scanner(System.in);

    public void invokeCalculator() {
        System.out.println("=== Enhanced Command Line Calculator ===");
        showMenu();
    }

    private void showMenu() {
        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-) ");
            System.out.println("3. Multiplication (*) ");
            System.out.println("4. Division (/)");
            System.out.println("5. Modulus (%)");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> add();
                case 2 -> subtract();
                case 3 -> multiply();
                case 4 -> divide();
                case 5 -> modulo();
                case 0 -> {return;}
                default -> System.out.println("Invalid option");
            }

        }
    }

}
