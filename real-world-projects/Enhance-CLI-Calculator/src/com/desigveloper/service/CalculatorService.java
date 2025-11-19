package com.desigveloper.service;

import com.desigveloper.model.Calculator;

import java.util.Scanner;

public class CalculatorService implements Calculator {
    private static final Scanner scanner = new Scanner(System.in);


    public void invokeCalculator() {
        boolean running = true;

        while (running) {
            showMenu();

            int choice = scanner.nextInt();

            switch (choice) {
                case 0 ->
                    System.exit(0);
                case 1 -> {
                    running = false;
                    performOperation();
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    private void showMenu() {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("=== Enhanced Command Line Calculator ===");
            System.out.println("1. Perform operation");
            System.out.println("0. Close program.");
            System.out.print("Choose an option: ");

    }

    private static double getNumber() {
        while (true) {
            if (CalculatorService.scanner.hasNextDouble()) {
                return CalculatorService.scanner.nextDouble();
            } else {
                System.out.println("Invalid number. Enter a valid number");
                CalculatorService.scanner.next(); // Clear invalid token
            }
        }
    }

    private static String getOperator() {
        while (true) {
            String input = CalculatorService.scanner.next().trim();

            if (input.equals("+") || input.equals("-") || input.equals("/")
                || input.equals("*") || input.equals("%") || input.equals("=")) {
                return input;
            } else {
                System.out.print("Invalid Operator: Enter +, -, *, /, % or " +
                        " = to complete");
                CalculatorService.scanner.next(); // Clear invalid operator
            }
        }
    }

    private void performOperation() {
        double currentValue = 0;
        boolean firstInputNotANumber = true;

        while (firstInputNotANumber) {
            System.out.print("Enter first number: ");
            currentValue = getNumber();
            firstInputNotANumber = false;
        }


        while (true) {
            System.out.print("Enter operator (+, -, *, /, %) or = to calculate: ");
            String operator = getOperator();

            if (operator.equals("=")) break;

            System.out.print("Enter next number: ");
            var nextNumber = getNumber();

           try {
                currentValue = switch (operator) {
                    case "+" -> add(currentValue, nextNumber);
                    case "-" -> subtract(currentValue, nextNumber);
                    case "*" -> multiply(currentValue, nextNumber);
                    case "/" -> divide(currentValue, nextNumber);
                    case "%" -> modulus(currentValue, nextNumber);
                    default -> currentValue;
                };
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
           }

        }

        System.out.println(currentValue);
    }

//    Operation methods implementations

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double subtract(double a, double b) {
        return a - b;
    }

    @Override
    public double multiply(double a, double b) {
        return a * b;
    }

    @Override
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }

    @Override
    public double modulus(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Modulus by zero is not allowed.");
        }
        return a % b;
    }
}
