package com.desigveloper.madlingame;

import java.util.Scanner;

/**
 * Program: Mad libs - A simple game where you create a story template with blanks for words.
 * Usage - Prompts for a noun, a verb, an adverb, and an adjective and 
 *      injects those into a story that you create.
 * 
 * Author: Desigveloper
 * Date: 20-08-2025
 */ 

public class MadLib {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a noun: ");
        String noun = input.next();

        System.out.print("Enter a verb: ");
        String verb = input.next();
        
        System.out.print("Enter an adjective: ");
        String adjective = input.next();
        
        System.out.print("Enter an adverb: ");
        String adverb = input.next();

        String storyTemplate = "Do you %s your %s %s %s? That's so hilarous!"
            .formatted(verb, adjective, noun, adverb);
        System.out.println(storyTemplate);

        input.close();
    }    
}
