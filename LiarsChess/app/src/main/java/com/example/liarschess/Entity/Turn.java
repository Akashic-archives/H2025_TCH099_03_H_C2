package com.example.liarschess.Entity;

public class Turn {
    String turnNumber;
    String Move;
    String Movelegality;
    String GameID;

    public Turn(){}

    public Turn(String turnNumber,String Move,String MoveLegality,String GameID){
        this.turnNumber = turnNumber;
        this.Move = Move;
        this.Movelegality = MoveLegality;
        this.GameID = GameID;
    }

    public String getTurnNumber() {return turnNumber;}
    public void setTurnNumber(String turnNumber) {this.turnNumber = turnNumber;}
    public String getMove() {return Move;}
    public void setMove(String move) {Move = move;}
    public String getMovelegality() {return Movelegality;}
    public void setMovelegality(String movelegality) {Movelegality = movelegality;}
    public String getGameID() {return GameID;}
    public void setGameID(String gameID) {GameID = gameID;}
}
