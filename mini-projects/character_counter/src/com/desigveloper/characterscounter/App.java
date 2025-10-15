package com.desigveloper.characterscounter;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        var counter = new CharactersCounter();
        String str = counter.getValidString(new Scanner(System.in));
        counter.displayOutput(str);
    }
}
