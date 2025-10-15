package com.desigveloper.tipcalculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        var calculator = new TipCalculator();
        
        double billAmount;
        double tipRate;
        double tip;
        double totalAmount;


        System.out.print("What is the bill amount: ");
        billAmount = calculator.getValidNumber(new Scanner(System.in), "bill amount");
        

        System.out.print("What is the tip rate: ");
        tipRate = calculator.getValidNumber(new Scanner(System.in), "tip rate");
        

        tip = billAmount * (tipRate / 100);
        totalAmount = billAmount + tip;

        calculator.displayOutput(tip, totalAmount);
    }
}