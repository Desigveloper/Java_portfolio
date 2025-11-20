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
            System.out.println("\n=== Enhanced Command Line Calculator (Enter '=' to show result)===");
            System.out.println("1. Perform operation");
            System.out.println("0. Close program.");
            System.out.print("Choose an option: ");

    }

    // Operation dispatcher
    private void performOperation() {
        double currentValue = 0;
        boolean firstInputNotANumber = true;

        while (true) {
            // Get first input
            if (firstInputNotANumber) {
                System.out.print("Enter first number: ");
                currentValue = getValidNumber();
                firstInputNotANumber = false;
            }

            System.out.print("Enter operator (+, -, *, /, %) or = to calculate: ");
            String operator = getOperator();

            if (operator.equals("=")) break;

            System.out.print("Enter next number: ");
            double nextNumber = getValidNumber();

           try {
                currentValue = performCalculation(currentValue, nextNumber, operator);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
           }

        }

        System.out.printf("Final result: %.2f", currentValue);
    }

    // Validate input
    private static double getValidNumber() {
        while (true) {
            if (CalculatorService.scanner.hasNextDouble()) {
                return CalculatorService.scanner.nextDouble();
            } else {
                System.out.println("Invalid number. Enter a valid number");
                CalculatorService.scanner.next(); // Clear invalid token
            }
        }
    }

    // Validate operator
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

    // Calculation dispatcher
    private double performCalculation(double currentValue, double nextNumber, String op) {
        return switch (op) {
            case "+" -> add(currentValue, nextNumber);
            case "-" -> subtract(currentValue, nextNumber);
            case "*" -> multiply(currentValue, nextNumber);
            case "/" -> divide(currentValue, nextNumber);
            case "%" -> modulus(currentValue, nextNumber);
            default -> throw new IllegalArgumentException("Invalid operation: " + " " + op + " ");
        };
    }


//    Modular Operation methods implementations
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
