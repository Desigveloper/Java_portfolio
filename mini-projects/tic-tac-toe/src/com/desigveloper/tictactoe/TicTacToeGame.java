package com.desigveloper.tictactoe;

import java.util.Random;

public class TicTacToeGame {
    private String[][] tictatctoeBoard;
    private char[] players = {'X', 'O'};

    // private String currentPlayer;
    // private String winner;
    // private char gameStatus; // 'N' - Not started, 'I' - In Progress, 'D' - Draw, 'W' - Win
    
    public void initializeBoard() {
        tictatctoeBoard = new String[3][3];
        Random rand = new Random();
        int randomIndex;
        System.out.println("Tic Tac Toe Board Initialized:");
        // System.out.println("Player " + players[randomIndex] + " starts first.");


        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                randomIndex = rand.nextInt(players.length);
                tictatctoeBoard[row][col] = players[randomIndex] + " | ";
                System.out.print(tictatctoeBoard[row][col]);
            }
            System.out.println();
        }
    }
}
