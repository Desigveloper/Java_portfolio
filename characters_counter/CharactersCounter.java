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

    private static String getValidString(Scanner sc) {
        System.out.print("What is the input string? ");
        String str;

        while ((str = sc.nextLine()).length() == 0) {
            System.out.print("String can't be empty. Enter a valid word: ");
        }

        return str;
    }

    private static void displayOutput(String str) {
        

        
        int strLength = countCharacters(str);
        System.out.println(str + " has " + strLength + " characters.");
    }

    public static void main(String[] args) {
        displayOutput(getValidString(new Scanner(System.in)));
    }
}
