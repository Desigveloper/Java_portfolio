package com.desigveloper.factorial;

import java.util.Scanner;

/**
 * Class: Factorial
 * 
 * Description: This class calculates the factorial of a given number input by the user.
 *              It takes an integer input from the user, checks if it's negative, zero, or one,
 *              and then calculates the factorial using a loop for numbers greater than one.
 *              The result is then printed to the console.
 * 
 * Methods:
 *  - main(String[] args): The main method of the class that takes user input, calculates the factorial,
 *                        and prints the result to the console.
 */

public class Factorial {
    private long fact;
    private int number;


    private void setNumber(Scanner sc) {
        System.out.print("Enter number: ");
        number = sc.nextInt();
    }


    private long factorial(int num) {
        this.fact = 1L;
        
        // When negative number is inputed
        if (num < 0) {
            System.out.println("Number must not be negative.");
            System.exit(0);
        }

        // When 0 is inputed
        if (num == 0) 
            return this.fact;

        for (long i = 1L; i <= num; i++) {
            try {
                fact = Math.multiplyExact(fact, i);
            } catch (Exception e) {
                System.out.printf("Long integer overflows at %d\n", i);
                System.exit(0);
            }
            
        } 

        return this.fact;
    }

    public void printFactorial() {
        setNumber(new Scanner(System.in));

        long factorial = factorial(number);

        if (factorial <= 0) {
            System.out.printf("The factorial of %d will overflow. Try a lesser number\n", number);
            System.exit(0);
        }

        System.out.printf("The factorial of %d is %d.\n", number, factorial);
    }
}
