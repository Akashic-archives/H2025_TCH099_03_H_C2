package com.example.liarschess.Entity;

public class Game {
String [] PieceNumber, InitialPosition, Type, State, CurrentPosition;

String whiteplayer;
String blackplayer;

public Game(String white,String black){
    this.whiteplayer = white;
    this.blackplayer = black;

}

    public String getBlackplayer() {
        return blackplayer;
    }

    public void setBlackplayer(String blackplayer) {
        this.blackplayer = blackplayer;
    }

    public String getWhiteplayer() {
        return whiteplayer;
    }

    public void setWhiteplayer(String whiteplayer) {
        this.whiteplayer = whiteplayer;
    }
}
