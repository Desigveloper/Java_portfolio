package bmi;

import java.util.Scanner;

public class App {
    // BMI = weight * 703 / height * height
    private static Scanner cin = new Scanner(System.in);
    public static void main(String[] args) {
        int age;
        double weight, height, bmi;

        System.out.print("Enter your age: ");
        age = Integer.parseInt(cin.nextLine());

        if (age < 18) {
            System.out.println("Invalid age");
        } else {
            System.out.print("Enter weight in pounds: ");
            weight = Double.parseDouble(cin.nextLine());

            System.out.print("Enter height in inches: ");
            height = Double.parseDouble(cin.nextLine());

            bmi = weight * 703 / Math.pow(height, 2);
            
            if (bmi < 15) {
                System.out.println("Very severely underweight");
            }
            else if(bmi >= 15 && bmi < 16) {
                System.out.println("Severely underweight");
            }
            else if (bmi >= 16 && bmi < 18.5) {
                System.out.println("underweight");
            }
            else if (bmi >= 18.5 && bmi < 25) {
                System.out.println("Normal weight");
            }
            else if (bmi >= 25 && bmi < 30){
                System.out.println("Overweight");
            }
            else if (bmi >= 30 && bmi < 35) {
                System.out.println("Severely overweight");
            }
            else {
                System.out.println("Very severely overweight");
            }
        }
    }
}
