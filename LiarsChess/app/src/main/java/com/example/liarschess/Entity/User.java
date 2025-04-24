package com.example.liarschess.Entity;

public class User {

    private String email;
    private String friends[];
    private String games[];
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String[] getFriends() {
        return friends;
    }
    public void setFriends(String friends[]) {
        this.friends = friends;
    }
    public String[] getGames() {
        return games;
    }
    public void setGames(String games[]) {
        this.games = games;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
