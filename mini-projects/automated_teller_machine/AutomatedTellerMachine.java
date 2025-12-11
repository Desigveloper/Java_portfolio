package automated_teller_machine;

import java.util.Scanner;

public class AutomatedTellerMachine {  
    private static final Scanner sc = new Scanner(System.in);

    private static boolean verifyUser(String pass) {
        boolean isVerified = false;
        int attempts = 2;
        String password = pass;
        
        do {
            if (password.equals("12345")) {
                isVerified = true;
                break;
            }
           
            
            if (attempts == 0) {
                System.out.println("PIN blocked!");
                System.exit(0);
            } else {
                System.out.print("Wrong PIN! You have " + attempts  + " attempts left. Try again: ");
                attempts--;
                password = sc.nextLine();
            }

        } while(!isVerified);
        

        return isVerified;
        
    }


    public static void makeWithdrawal(int amount) {
        int fiveDollarNote, twoDollarNote, oneDollarNote;
        int tenDollarNote = fiveDollarNote = twoDollarNote = oneDollarNote = 0;
        if (amount / 10 >= 1) {
                tenDollarNote = amount / 10;
                amount %= 10;

        }
        if (amount / 5 >= 1) {
                fiveDollarNote = amount / 5;
                amount %= 5;
        }
        
        if (amount / 2 >= 0) {
                twoDollarNote = amount / 2;
                amount %= 2;
        }
        
        oneDollarNote = amount;

       System.out.printf("%d notes(s) of $10, %d note(s) of $5, %d notes(s) of $2, and %d note(s) of $1\n",
            tenDollarNote, fiveDollarNote, twoDollarNote, oneDollarNote
       );
    }
    
    public static void main(String[] args) {
        System.out.print("Enter your PIN: ");
        String pin = sc.nextLine();

        boolean success = verifyUser(pin);

        if (success) {
            System.out.print("Enter amount: ");
            int amount = Integer.parseInt(sc.nextLine());
            makeWithdrawal(amount);

            System.out.println("Transaction successfully completed!");
        }
    }
}
