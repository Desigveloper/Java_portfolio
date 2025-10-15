package com.desigveloper.piratepuzzle;
/**
 * Program: Pirate puzzle - A Java brute-force program
 *  The program solves: (X O L) + (L X X) = (T L T) where the equation si
 *      => (100X + 10O + L) + (100L + 10X + X) = (100T + 10L + T)
 *      => 111X + 10O + 91L = 101T;
 *  The program bute-forces all digits (0-9) for X, O, L, T that make the addition valid.
 *  It finds all possible combinations and marks which have all distinct values
 * 
 * @author Desigveloper @since 07-10-2025
 * 
*/

public class PiratePuzzle {
    private void bruteForceDigits() {
        for (int x = 0; x <= 9; x++) {
            for (int o = 0; o <= 9; o++) {
                for (int l = 0; l <= 9; l++) {
                    for (int t = 0; t <= 9; t++) {
                        int left = 111 * x + 10 * o + 91 * l;
                        int right = 101 * t;

                        if (left == right) {
                            boolean isXDistinct = x != o && x != l && x != t;
                            boolean isODistint = o != l && o != t;
                            boolean isLDistinct = l != t;

                            boolean allDifferent = (isXDistinct && isODistint && isLDistinct);
                            
                            System.out.printf("X=%d, O=%d, L=%d, T=%d", x, o, l, t);
                            
                            if (allDifferent) 
                                System.out.print(" <-- All Different ✅");
                        
                            System.out.println();
                        }
                    }
                }
            }
        }
    }

    public void solvePuzzle() {
        bruteForceDigits();
    }
}
