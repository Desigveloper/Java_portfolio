package com.desigveloper.chatbot;


import java.util.Scanner;;

/** 
 * A simple chatbot or digital assistant application
 * Main class to run the chatbot application
 */ 



public class Bot {
    private String botName;
    private String botVersion;
    private String botYear;
    
    public Bot() {
        this.botName = "Vexa";
        this.botVersion = "1.0";
        this.botYear = "2025";

        greet();
    }

    private void greet() {
        System.out.printf("Hello! I am %s, your virtual assistant.\n", botName);
        System.out.printf("I am running on version %s\n", botVersion);
        System.out.printf(" and I was created in %s.\n", botYear);
        System.out.println("Please remind me your name");
    }

    private void remindName(Scanner sc) {
        String userName = sc.nextLine();
        System.out.printf("Nice to meet you, %s. And a great name you have, %s!\n", userName, userName);
    }

    private void guessAge(Scanner sc) {
        System.out.println("Let me guess your age.");
            System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");

            // reading all remainders
            int rem3 = sc.nextInt();
            int rem5 = sc.nextInt();
            int rem7 = sc.nextInt();

            // Calculating with a special formular
            int age = (rem3 * 70 + rem5 * 21 + rem7 * 15) % 105;
            System.out.printf("Your age is %s; that's a good time to start programming!%n", age);  
    }

    private void count(Scanner sc) {
        System.out.println("Now I will prove to you that I can count to any number you want.");

        // read a number and count to it here
        int number = sc.nextInt();

        for (int i = 0; i <= number ; i++) {
            System.out.println(i + "!");
        }
    }

    private void test(Scanner sc) {
        System.out.println("Let's test your programming knowledge.");

        // write your code here
        System.out.println("Why do we use methods?");
        System.out.println("A. To repeat a statement multiple times.");
        System.out.println("B. To decompose a program into several small subroutines.");
        System.out.println("C. To determine the execution time of a program.");
        System.out.println("D. To interrupt the execution of a program.");

        String answer = sc.next();

        while (!(answer.equalsIgnoreCase("b"))) {
            // Exiting query
            if (answer.equalsIgnoreCase("exit") || answer.equalsIgnoreCase("quit")) {
                exitChat(new Scanner(System.in));
            }

            System.out.println("Please, try again.");
            answer = sc.next();
        }
    }

    public void startChat() {
        remindName(new Scanner(System.in));
        guessAge(new Scanner(System.in));
        count(new Scanner(System.in));
        test(new Scanner(System.in));
    }

    private void exitChat(Scanner sc) {
        System.out.println("Do you really want to exit? (yes/no)");
        String userInput = sc.nextLine();

        if (userInput.equalsIgnoreCase("yes")) {
            System.out.println("Thank you for chatting with me. Have a great day!");
            System.exit(0);
        } 
    }

    public void endChat() {
        System.out.println("Congratulations, have a nice day!");
    }

}

