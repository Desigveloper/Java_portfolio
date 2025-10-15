package com.desigveloper.compountinterestcalc;

import java.io.PrintWriter;
import java.util.Scanner;

/**
* This program shows how to store tabular data in a 2D array.
* @version 1.0 2025-02-25
* @author Desigveloper
*/

public class CompoundInterest {
    private final double MINIMUMRATE = 10;
    private final int RATES = 6;
    private int numberOfYears;
    private double initialBalance;

    private double[] interestRates = new double[RATES];
    
    // Set interest rates from 10......15%
    private void setInterestRates() {
        for (int i = 0; i < interestRates.length; i++) {
            interestRates[i] = (MINIMUMRATE + i) / 100;
        }
    }
    
    // Get number of years and set size of balance table
    private void setNumberofYears(Scanner sc) {
        System.out.print("How many years will the interest be accumulated? ");
        this.numberOfYears = sc.nextInt();
    }
    
    // Get the amount taken and Set initial balances
    private void setInitialBalance(Scanner sc) {
        System.out.print("What is the amount taken? ");
        this.initialBalance = sc.nextDouble();
    }
    
    private double[][] calculateInterest() {
        setInterestRates();
        setNumberofYears(new Scanner(System.in));
        setInitialBalance(new Scanner(System.in));
        
        double[][] balances = new double[this.numberOfYears][this.RATES];

        // Set initial balance for each rate
        for (int i = 0; i < balances[0].length; i++) {
            balances[0][i] = initialBalance;
        }
        
         // Compute balances for future years
         for (int j = 1; j < balances.length; j++) {
             for (int k = 0; k < balances[j].length; k++) {
                 //  Get old balances
                 double oldBalance = balances[j - 1][k];
                
                 // Compute interest
                 double interest = oldBalance * interestRates[k];
                
                 //  Compute new balance
                 balances[j][k] = oldBalance + interest;
             }
        }

        return balances;
    }
        
        // Printing the balance table to a file
        public void printBalances() {
            double balances[][] = calculateInterest();
            try {
                var writer = new PrintWriter("compound_interest//compound-interest-table.txt");
                
                // Print heading to file
                String strHeader = "\t\t\tTable of computed compound interests for %d years".formatted(numberOfYears);
                writer.write(strHeader.toUpperCase());
                writer.println();
                writer.println("\t\t\t--------------------------------------------------");
                writer.println();
                
                //    Print one row of interest rate to file
                String intRateText = "Int. Rates";
                writer.write(intRateText);

                for (double ds : interestRates) {
                    //System.out.printf("\t%7.0f%%", (100 * ds) );
                    String strInterestRates = "\t%7.0f%%".formatted(ds * 100);
                    writer.write(strInterestRates);
                }
                //System.out.println();
                writer.println();
    
                // Print balance 

                int year = 1;
                for (double[] row : balances) {
                    //System.out.printf("Year %d\t", year);
                    String strYear = "Year %d\t".formatted(year);
                    writer.write(strYear);
                    
                    for (double val : row) {
                        String strBal = "\t\tGHc%.2f".formatted(val);
                        
                        writer.write(strBal);
                        //System.out.printf("\t%.2f", val);
                    }

                    //System.out.println();
                    writer.println();
                    year++;
                } 
                
                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
