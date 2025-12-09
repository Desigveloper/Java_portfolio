package automated_teller_machine;

import java.util.Scanner;

public class AutomatedTellerMachine {  
    private static final Scanner sc = new Scanner(System.in);

    private static boolean verifyUser(String password) {
        boolean isVerified = false;
        
        if (password.equals("12345")) 
           isVerified = true;

        return isVerified;
    }


    public static void makeWithdrawal(int amount) {
        
       while (amount > 0) {
            if
       }
    }
    
    public static void main(String[] args) {
         System.out.print("Enter your PIN: ");
        String pin = sc.nextLine();

        boolean success = verifyUser(pin);

        if (success) {
            System.out.print("Enter amount: ");
            int amount = Integer.parseInt(sc.nextLine());
            makeWithdrawal(amount);

            System.out.println("Money successfully withdrawn!");
        } else {
            System.out.println("You entered a wrong PIN");
        }
    }
}
