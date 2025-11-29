package id_generator;

import java.util.Scanner;

public class LoginID {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String name, loginId;
        int randomInt;

        System.out.print("Enter you first name: ");
        name = sc.nextLine();

        randomInt = (int)(Math.random() * 900) + 100; // Generates a random number between 100 and 999

        loginId = name.substring(0, 4).toUpperCase() + randomInt;

        System.out.printf("LoginID: %s\n", loginId);

    }
}
