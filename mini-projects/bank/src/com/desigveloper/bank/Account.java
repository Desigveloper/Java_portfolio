package com.desigveloper.bank;

/**
 * Project: Bank depost/withdrawal/ transfer account
 *  - This project is based on a banking theme and is in two parts.
 *      First, allows user to withdraw and deposit funds in an Account.
 *      Then allows user to transfer money between Accounts.
 * 
 * @author Desigveloper 12-10-2025
*/

public class Account {
    private String accountNumber;
    private double balance;

    Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    Account() {
        this("unknown", 0.0);
    }

    public String getNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void withdrawFund(double amount) {
        if (this.balance < amount ) {
            System.out.println("You have insufficient funds in account.");
            System.exit(0);
        } else {   
            this.balance -= amount;
        }
        
        System.out.printf("Account has been debited GHc%.2f\n", amount);
        System.out.printf("Bal: GHc%.2f\n", this.balance);
    }

    public void depositFund(double amount) {
        if (amount < 0 ) {
            System.out.println("Negative numbers are not accepted");
            System.exit(0);
        } else {   
            this.balance += amount;
        }

        System.out.printf("Account has been credited GHc%.2f\n", amount);
        System.out.printf("Bal: GHc%.2f\n", this.balance);
    }

    public void transferFund(Account creditAccount, double amount) {
        if (amount > this.balance ) {
            System.out.println("You have insufficient funds in account to complete this transaction.");
            System.exit(0);
        } else {
            this.balance -= amount;
            creditAccount.balance += amount;   
        }

        System.out.println("Transfer successful.");
    }
}
