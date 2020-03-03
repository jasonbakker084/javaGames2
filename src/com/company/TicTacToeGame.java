package com.company;

import java.util.Random;

public class TicTacToeGame {

    Random rand = new Random();

    private Player player1;
    private Player player2;
    public Player currentPlayer;
    private boolean gameEnded = false;

    private int number = 1 + rand.nextInt(9);
    private int rij = (number - 1) / 3;
    private int kolom = (number - 1) % 3;

    char[][] grid = new char[3][3];

    public TicTacToeGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        for (int rij = 0; rij < 3; rij++) {
            for (int kolom = 0; kolom < 3; kolom++) {
                grid[rij][kolom] = (char) ('1' + kolom + rij * 3);
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < grid.length; i++) {
            for (int x = 0; x < grid.length; x++) {
                System.out.print(" | " + grid[i][x]);
            }
            System.out.println(" | ");
        }
        System.out.println("Next player!" + "\n");
    }

    public void setField(int number, char pawn) {
        grid[(number - 1) / 3][(number - 1) % 3] = pawn;
    }

    public void winConditions() {
            //loops through rows checking if win-condition exists
        for(int r = 0; r < 3; r++) {
            if (grid[rij][0] == grid[rij][1] && grid[rij][1] == grid[rij][2] && grid[rij][0] != '-')
                gameEnded = true;
        }
            //loops through columns checking if win-condition exists
        for(int c = 0; c < 3; c++) {
            if (grid[0][kolom] == grid[1][kolom] && grid[1][kolom] == grid[2][kolom] && grid[0][kolom] != '-')
                gameEnded = true;
        }
            //checks diagonals for win-condition
            if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != '-')
                gameEnded = true;

            if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != '-')
                gameEnded = true;
        }

    public void showScore() {
        if (currentPlayer == player1) {
            System.out.println(player2.getPlayerName() + " has won!");
            player2.addScore();
            System.out.println("Total score " + player1.getPlayerName() + ":" + " " + player1.getPlayerScore());
            System.out.println("Total score " + player2.getPlayerName() + ":" + " " + player2.getPlayerScore() + "\n");

        } else {
            System.out.println(player1.getPlayerName() + " has won!");
            player1.addScore();
            System.out.println("Total score " + player2.getPlayerName() + ":" + " " + player2.getPlayerScore());
            System.out.println("Total score " + player1.getPlayerName() + ":" + " " + player1.getPlayerScore() + "\n");
        }
    }

    public void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
            winConditions();
        } else {
            currentPlayer = player1;
            winConditions();
        }
    }

    public void playTicTacToe() throws InterruptedException {

        while (!gameEnded) {
            Thread.sleep(4000);
            System.out.print(currentPlayer.getPlayerName() + " choose number: " + "\n");
            int number = 1 + rand.nextInt(9);
            System.out.println(number);
            setField(number, currentPlayer.getPawn());
            printBoard();
            switchPlayer();
//            winConditions();
        }
        if (gameEnded = true) {
            System.out.println("The game has ended!" + "\n");
            showScore();
        }
    }
}
