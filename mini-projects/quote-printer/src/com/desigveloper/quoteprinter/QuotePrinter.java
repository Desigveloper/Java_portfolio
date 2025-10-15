package com.desigveloper.quoteprinter;
import java.util.Scanner;

public class QuotePrinter {
    public String processQuote(Scanner sc) {
        System.out.print("What is the quote? ");
        String quote = sc.nextLine();

        System.out.print("Who said it? ");
        String author = sc.nextLine();

        StringBuilder completeQuote = new StringBuilder();

        completeQuote.append(author);
        completeQuote.append(" says ");
        completeQuote.append("\"");
        completeQuote.append(quote);

        if (!quote.contains(".")) {
            completeQuote.replace(completeQuote.toString().length(), 
                completeQuote.toString().length(), ".\""); 
        } 

        return completeQuote.toString();
    }
}
