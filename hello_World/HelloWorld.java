package hello_World;

import java.util.Scanner;

public class HelloWorld {

    private static void sayGreetings(Scanner sc) {
        String[] greetings = {"Hello", "Hi", "Hey", "Greetings", "Salutations"};
        int randomIndex = (int) (Math.random() * greetings.length);


        System.out.print("What is you name? ");
        String name = sc.nextLine();

        System.out.println(greetings[randomIndex]  + ", " + name + ", nice to meet you!");
    }
    public static void main(String[] args) {
        sayGreetings(new Scanner(System.in));
    }
}
