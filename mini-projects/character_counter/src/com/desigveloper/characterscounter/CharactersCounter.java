package com.desigveloper.characterscounter;


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

    public String getValidString(Scanner sc) {
        System.out.print("What is the input string? ");
        String str;

        while ((str = sc.nextLine()).length() == 0) {
            System.out.print("String can't be empty. Enter a valid word: ");
        }

        return str;
    }

    public void displayOutput(String str) {
        

        
        int strLength = countCharacters(str);
        System.out.println(str + " has " + strLength + " characters.");
    }
}
