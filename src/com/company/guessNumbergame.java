package com.company;

import java.util.Random;

class guessNumbergame {

    Random rand = new Random();

    private int rand_int1 = rand.nextInt(10);
    private int secretNumber = 7;
    private int guessNumber = rand_int1;
    private Player player1;
    private Player player2;
    public Player currentPlayer;

    public guessNumbergame(Player player1, Player player2) {
       this.player1 = player1;
       this.player2 = player2;
       this.currentPlayer = player1;
    }

    public int getRand_int1() {
        return rand_int1;
    }

    public void setRand_int1(int rand_int1) {
        this.rand_int1 = rand_int1;
    }

    public int getSecretNumber() {
        return secretNumber;
    }

    public void setSecretNumber(int secretNumber) {
        this.secretNumber = secretNumber;
    }

    public int getGuessNumber() {
        return guessNumber;
    }

    public void setGuessNumber(int guessNumber) {
        this.guessNumber = guessNumber;
    }

    public void startGuess() throws InterruptedException {

        String currentPlayer = player1.getPlayerName();

        while (secretNumber != guessNumber) {
            if (currentPlayer.equals(player1.getPlayerName())) {
                currentPlayer = player2.getPlayerName();
                for (int i = 0; i < 1; i++) {
                    Thread.sleep(4000);
                    guessNumber = rand.nextInt(10);
                    System.out.println("Player: " + currentPlayer);
                    System.out.println(guessNumber);
                }
            } else {
                currentPlayer = player1.getPlayerName();
                for (int i = 0; i < 1; i++) {
                    Thread.sleep(4000);
                    guessNumber = rand.nextInt(10);
                    System.out.println("Player: " + currentPlayer);
                    System.out.println(guessNumber);
                }
            }

            if (guessNumber < secretNumber) {
                System.out.println("Wrong number, guess higher!" + "\n");
            } else if (guessNumber > secretNumber) {
                System.out.println("Wrong number. guess lower!" + "\n");
            } else {
                System.out.println("Correct!");
            }
        }
        if (currentPlayer == player1.getPlayerName()) {
            player1.addScore();
            System.out.println("Total score: " + player1.getPlayerName() + " " + player1.getPlayerScore());
            System.out.println("Total score: " + player2.getPlayerName() + " " + player2.getPlayerScore() + "\n");
            System.out.println("Play again?" + "\n");
        } else {
            player2.addScore();
            System.out.println("Total score: " + player1.getPlayerName() + " " + player1.getPlayerScore());
            System.out.println("Total score: " + player2.getPlayerName() + " " + player2.getPlayerScore() + "\n");
            System.out.println("Play again?" + "\n");
        }
    }
}
