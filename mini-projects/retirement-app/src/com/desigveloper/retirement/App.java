package com.desigveloper.retirement;

import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        var calculator = new RetirementCalculator();

        System.out.print("What is your current age? ");
        int currentAge = calculator.getValidInput(new Scanner(System.in));

        System.out.print("At what is the legal retirement age in your country? ");
        int expectedAge = calculator.getValidInput(new Scanner(System.in));

        int yearsLeft = calculator.calculateYearsLeft(currentAge, expectedAge);

        calculator.displayYearsAndDate(yearsLeft, LocalDate.now());
    }
}
