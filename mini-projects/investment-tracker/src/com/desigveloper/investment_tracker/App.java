package com.desigveloper.investment_tracker;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        var tracker = new InvestmentTracker();
        tracker.setDaysHeld(new Scanner(System.in)); // Set the holding period to 30 days
        int daysHeld = tracker.getDaysHeld();

        double earnings = tracker.calculateEarnings(daysHeld);
        tracker.displayEarnings(daysHeld, earnings);
    }
}
