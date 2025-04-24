package com.example.liarschess.Entity;

public class Game {
    String GameID;
    String WinnerID;

    public Game(){}
    public Game(String GameID, String WinnerID){
        this.GameID = GameID;
        this.WinnerID = WinnerID;
    }

    public String getGameID() {return GameID;}
    public void setGameID(String gameID) {GameID = gameID;}
    public String getWinnerID() {return WinnerID;}
    public void setWinnerID(String winnerID) {WinnerID = winnerID;}
}
