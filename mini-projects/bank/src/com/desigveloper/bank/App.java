package com.desigveloper.bank;
public class App {
    public static void main(String[] args) throws Exception {
        var account1 = new Account("100012", 1000);
        System.out.printf("Account: %s\nBal: GHc%.2f\n", account1.getNumber(), account1.getBalance());

        account1.withdrawFund(100);
        System.out.printf("Account: %s\nBal: GHc%.2f\n", account1.getNumber(), account1.getBalance());

        account1.depositFund(500);


        var account2 = new Account("100005", 125);
        account1.transferFund(account2, 100);
        account2.depositFund(300);

        System.out.printf("Account: %s\nBal: GHc%.2f\n", account1.getNumber(), account1.getBalance());
        System.out.printf("Account: %s\nBal: GHc%.2f\n", account2.getNumber(), account2.getBalance());

        account2.transferFund(account1, 200);

        System.out.printf("Account: %s\nBal: GHc%.2f\n", account1.getNumber(), account1.getBalance());
        System.out.printf("Account: %s\nBal: GHc%.2f\n", account2.getNumber(), account2.getBalance());
    }
}
