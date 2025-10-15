package com.desigveloper.investment_tracker;


import java.util.Scanner;

/**
 * Project: Investment Tracker - A simple application to track investment profits and losses.
 * Author: Desigveloper
 * Date: 2025-08-22
 * */ 

public class InvestmentTracker {
    double buyingPricePerShare;
    double closingPricePerDay;
    int numberOfShares;
    int daysHeld;

    public InvestmentTracker() {
        this.setBuyingPrice(new Scanner(System.in));
        this.setClosingPrice(new Scanner(System.in));
        this.setNumberOfShares(new Scanner(System.in));
    }


    private void setBuyingPrice(Scanner scanner) {
        System.out.print("Enter your buying price per share: ");
        this.buyingPricePerShare = scanner.nextDouble();
    }

    private void setClosingPrice(Scanner scanner) {
        System.out.print("Enter your closing price per day: ");
        this.closingPricePerDay = scanner.nextDouble();
    }

    public void setDaysHeld(Scanner sc) {
        System.out.print("Enter the numbers of days the shares will be held: ");
        this.daysHeld = sc.nextInt();
    }

    public int getDaysHeld() {
        return this.daysHeld;
    }

    private void setNumberOfShares(Scanner scanner) {
        System.out.print("Enter the number of shares you own: ");
        this.numberOfShares = scanner.nextInt();
    }

    public double calculateEarnings(int daysHeld) {
        ///ArrayList<Double> weeklyEarnings = new ArrayList<>();

        double totalBuyingPrice = buyingPricePerShare * numberOfShares;
        double totalClosingPrice = closingPricePerDay * numberOfShares;
        return totalClosingPrice - totalBuyingPrice;
    }

    public void displayEarnings(int daysHeld, double earnings) {
        String messege = "Your total earnings over %d days is: %.2f.".formatted(daysHeld, calculateEarnings(daysHeld));
        System.out.println(messege);
    }
}
