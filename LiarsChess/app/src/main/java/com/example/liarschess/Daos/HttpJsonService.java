package com.example.liarschess.Daos;

import com.example.liarschess.Entity.Game;
import com.example.liarschess.Entity.Piece;
import com.example.liarschess.Entity.Turn;
import com.example.liarschess.Entity.User;
import com.fasterxml.jackson.databind.ObjectMapper; //TODO: install jackson


import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class HttpJsonService {
    private static final String URL_ENTRY_POINT = "http://10.0.2.2:3000/"; // entry from VM to localhost

    private static final String USER_URL = URL_ENTRY_POINT+"/api/web/user";
    private static final String GAME_URL = URL_ENTRY_POINT+"Game";
    private static final String TURN_URL = URL_ENTRY_POINT+"Turn";
    private static final String PIECE_URL = URL_ENTRY_POINT+"Pieces";
    private static final String MATCH_URL = URL_ENTRY_POINT+"Game_User";

    private OkHttpClient client = new OkHttpClient();
    private final String TAG = "HttpJsonService";

    private static HttpJsonService instance = null;

    public static HttpJsonService getInstance() {
        if (instance==null)
            instance = new HttpJsonService();
        return instance;
    }

    public List<User> getfriends(String userID) throws IOException {
        String url = USER_URL+"?";
        if(userID != null && !userID.isEmpty()) url += "UserID="+userID+"&";

        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        ResponseBody responseBody = response.body();

        if(responseBody != null){
            String jsonstr = responseBody.string();
            ObjectMapper mapper = new ObjectMapper();
            return Arrays.asList(mapper.readValue(jsonstr, User[].class));
        }
        return Collections.emptyList();

    }

    public List<Game> getGames(String gameID) throws IOException {
        String url = GAME_URL+"?";
        if(gameID != null && !gameID.isEmpty()) url += "UserID="+gameID+"&";

        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        ResponseBody responseBody = response.body();

        if(responseBody != null){
            String jsonstr = responseBody.string();
            ObjectMapper mapper = new ObjectMapper();
            return Arrays.asList(mapper.readValue(jsonstr, Game[].class));
        }
        return Collections.emptyList();

    }

    public List<Turn> getTurns() throws IOException {
        Request request = new Request.Builder().url(TURN_URL).build();
        Response response = client.newCall(request).execute();
        ResponseBody responseBody = response.body();

        if(responseBody != null){
            String jsonstr = responseBody.string();
            ObjectMapper mapper = new ObjectMapper();
            return Arrays.asList(mapper.readValue(jsonstr, Turn[].class));
        }
        return Collections.emptyList();

    }
    public List<Piece> getPieces() throws IOException {
        Request request = new Request.Builder().url(PIECE_URL).build();
        Response response = client.newCall(request).execute();
        ResponseBody responseBody = response.body();

        if(responseBody != null){
            String jsonstr = responseBody.string();
            ObjectMapper mapper = new ObjectMapper();
            return Arrays.asList(mapper.readValue(jsonstr, Piece[].class));
        }
        return Collections.emptyList();

    }



}


