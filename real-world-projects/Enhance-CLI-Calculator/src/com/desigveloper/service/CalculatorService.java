package com.desigveloper.service;

import com.desigveloper.model.Calculator;

import java.util.Scanner;

public class CalculatorService implements Calculator {
    private static Scanner scanner = new Scanner(System.in);


    public void invokeCalculator() {
        boolean running = true;

        while (running) {
            showMenu();

            int choice = scanner.nextInt();

            switch (choice) {
                case 0 -> {
                    System.exit(0);
                }
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

    private static double getNumber(Scanner scanner) {
        while (true) {
            if (scanner.hasNextDouble()) {
                return scanner.nextDouble();
            } else {
                System.out.println("Invalid number. Enter a valid number");
                scanner.next(); // Clear invalid token
            }
        }
    }

    private static String getOperator(Scanner scanner) {
        while (true) {
            String input = scanner.next().trim();

            if (input.equals("+") || input.equals("-") || input.equals("/")
                || input.equals("*") || input.equals("%") || input.equals("=")) {
                return input;
            } else {
                System.out.print("Invalid Operator: Enter +, -, *, /, % or " +
                        " = to complete");
                scanner.next(); // Clear invalid operator
            }
        }
    }

    private void performOperation() {
        System.out.print("Enter first number: ");
        var finalResult = getNumber(scanner);


        while (true) {
            System.out.print("Enter operator (+, -, *, /, %) or = to calculate: ");
            String operator = getOperator(scanner);

            if (operator.equals("=")) break;

            System.out.print("Enter next number: ");
            var nextNumber = getNumber(scanner);

            finalResult =  switch (operator) {
                case "+" -> add(finalResult, nextNumber);
                case "-" -> subtract(finalResult, nextNumber);
                case "*" -> multiply(finalResult, nextNumber);
                case "/" -> divide(finalResult, nextNumber);
                case "%" -> modulus(finalResult, nextNumber);
                default -> finalResult;
            };

        }

        System.out.println(finalResult);
    }

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
