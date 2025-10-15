package com.desigveloper.quoteprinter;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        var qp = new QuotePrinter();
        String quote = qp.processQuote(new Scanner(System.in));

        System.out.println(quote);
    }
}
