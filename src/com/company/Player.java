package com.company;

public class Player {

    private String playerName;
    private int playerScore;
    private char pawn;

    public Player(String playerName, char pawn) {
        this.playerName = playerName;
        this.playerScore = 0;
        this.pawn = pawn;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public char getPawn() {
        return pawn;
    }

    public void setPawn(char pawn) {
        this.pawn = pawn;
    }

    public void addScore(){
        playerScore++;
    }
}
