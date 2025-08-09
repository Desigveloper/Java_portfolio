package print_Quote;

import java.util.Scanner;

public class QuotePrinter {
    private static String processQuote(Scanner sc) {
        System.out.print("What is the quote? ");
        String quote = sc.nextLine();

        System.out.print("Who said it? ");
        String author = sc.nextLine();

        if (quote.contains(".")) {
            return author + " says, " + "\"" + quote + "\"";
        } else {
            return author + " says, " + "\"" + quote + ".\"";
        }
    }
    public static void main(String[] args) {
        String quote = processQuote(new Scanner(System.in));

        System.out.println(quote);
    }
}
