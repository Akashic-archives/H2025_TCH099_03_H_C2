package com.example.liarschess.Daos;

import com.example.liarschess.Entity.Game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameDao {

    private List<Game> games = new ArrayList<>();
    private static GameDao instance = null;

    public static GameDao getInstance(){
        if(instance == null)
            instance = new GameDao();
        return instance;
    }

    //DEMO METHODS. THIS PART OF THE PROJECT IS IMCOMPLETE
    private GameDao(){
        Game g;
        String[] whiteplayers = {"Ekrem","Ekrem","Ekrem","Mhamed"};
        String[] blackplayers = {"Pablo","Marcus","Mhamed","Ekrem"};

        //initializing demo data

        for (int i = 0; i <whiteplayers.length; i++){
            g = new Game(whiteplayers[i],blackplayers[i]);

            games.add(g);
        }
    }
    public List<Game> getGames(){
        return games;
    }
    public static List<Game> getGames(String userID) throws IOException {
        return new HttpJsonService().getGames(userID);
    }
}
