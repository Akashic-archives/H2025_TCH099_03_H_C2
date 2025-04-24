package com.example.liarschess.Daos;

import com.example.liarschess.Entity.Game;

import java.io.IOException;
import java.util.List;

public class GameDao {
    public static List<Game> getGames(String userID) throws IOException {
        return new HttpJsonService().getGames(userID);
    }
}
