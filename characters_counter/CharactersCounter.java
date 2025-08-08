package characters_counter;

import java.util.Scanner;

public class CharactersCounter {
    private static int countCharacters(String str) {
        int strLen = 0;

        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                strLen++;
            }
        }

        return strLen;

    }

    private static void displayOutput(Scanner sc) {
        System.out.print("What is the input string? ");

        String str = sc.nextLine();
        int strLength = countCharacters(str);
        System.out.println(str + " has " + strLength + " characters.");
    }

    public static void main(String[] args) {
        displayOutput(new Scanner(System.in));
    }
}
