package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner inputName = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        String playerName1;
        String playerName2;
        boolean debug = true;
        boolean loopGame = true;

        char a = 0;
        char b = 0;

        System.out.println("Welcome to Minigames!");
        System.out.print("Enter name player1: ");

        playerName1 = debug ? "Jason" : inputName.nextLine();
        System.out.print("Enter name player2: " + "\n");

        playerName2 = debug ? "Lenneke" : inputName.nextLine();
        Player player1 = new Player(playerName1, a);
        Player player2 = new Player(playerName2, b);
        System.out.println(player1.getPlayerName() + " choose pawn. (X or O)");

        a = input.next().charAt(0);
        if (a == 'X') {
            player1.setPawn('X');
             player2.setPawn('O');
        } else if (a == 'O') {
            player2.setPawn('X');
            player1.setPawn('O');
        }

        System.out.println(player1.getPlayerName() + " = " + player1.getPawn());
        System.out.println(player2.getPlayerName() + " = " + player2.getPawn() + "\n");
        String players = player1.getPlayerName() + " & " + player2.getPlayerName();
        System.out.println("Welcome " + player1.getPlayerName() + " & " + player2.getPlayerName() + "!");

        while (loopGame) {

            System.out.println("Choose a game:");
            System.out.println("1: Guess the Number");
            System.out.println("2: Tic Tac Toe");
            System.out.println("3: Four in A Row");
            System.out.println("4: Exit games");
            System.out.println("5: Total score players" + "\n");
            int games = 1 + rand.nextInt(2);
            String currentPlayer = player1.getPlayerName();

            switch (games) {
                case 1:
                    System.out.println("Guess the Number");
                    System.out.println("Hello " + players + ", welcome to the guessNumber game!");
                    System.out.println("Guess a number between 0 and 10");

                    guessNumbergame guessNumbergame1 = new guessNumbergame(player1, player2);
                    guessNumbergame1.startGuess();
                    break;

                case 2:
                    System.out.println("Tic Tac Toe");
                    System.out.println(player1.getPlayerName() + " = " + player1.getPawn());
                    System.out.println(player2.getPlayerName() + " = " + player2.getPawn());

                    TicTacToeGame TicTacToe = new TicTacToeGame(player1, player2);
                    TicTacToe.playTicTacToe();

                    break;

                case 3:
                    System.exit(0);
                    break;

                case 4:
                    System.out.println("Total score " + player1.getPlayerName() + ": " + player1.getPlayerScore() + ".");
                    System.out.println("Total score " + player2.getPlayerName() + ": " + player2.getPlayerScore() + "." + "\n");
            }
            if (false) {
                System.exit(0);
            }
        }
    }
}
