package com.example.liarschess.Entity;

public class Piece {
    String PieceID;
    String PieceNumber;
    String InitialPosition;
    String Type;
    String State;
    String CurrentPostion;
    String CurrentGameID;

    public Piece(){}
    public Piece(String pieceID, String pieceNumber, String initialPosition, String type, String state, String currentPostion, String currentGameID) {
        PieceID = pieceID;
        PieceNumber = pieceNumber;
        InitialPosition = initialPosition;
        Type = type;
        State = state;
        CurrentPostion = currentPostion;
        CurrentGameID = currentGameID;
    }
    public String getPieceID() {
        return PieceID;
    }

    public void setPieceID(String pieceID) {
        PieceID = pieceID;
    }

    public String getPieceNumber() {
        return PieceNumber;
    }

    public void setPieceNumber(String pieceNumber) {
        PieceNumber = pieceNumber;
    }

    public String getInitialPosition() {
        return InitialPosition;
    }

    public void setInitialPosition(String initialPosition) {
        InitialPosition = initialPosition;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getCurrentPostion() {
        return CurrentPostion;
    }

    public void setCurrentPostion(String currentPostion) {
        CurrentPostion = currentPostion;
    }

    public String getCurrentGameID() {
        return CurrentGameID;
    }

    public void setCurrentGameID(String currentGameID) {
        CurrentGameID = currentGameID;
    }
}
