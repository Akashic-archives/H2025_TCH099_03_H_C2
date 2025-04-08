package com.example.liarschess;

import android.util.Log;

import com.example.liarschess.User;
// import com.fasterxml.jackson.databind.ObjectMapper; TODO: install jackson

import org.json.JSONObject;

/*import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;*/

public class HttpJsonClientsDao {
    final String URL_ENTRY_POINT = "http://10.0.2.2:3000/"; // placeholder

    private final String TAG = "HttpJsonClientsDao";

    private static HttpJsonClientsDao instance = null;

    public static HttpJsonClientsDao getInstance() {
        if (instance==null)
            instance = new HttpJsonClientsDao();
        return instance;
    }

    public User[] getUsers(){ // TODO: install okttp
/*        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL_ENTRY_POINT)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();
            assert responseBody != null;
            String jsonData = responseBody.string();

            Log.d(TAG, jsonData);

            ObjectMapper mapper = new ObjectMapper();
            User users[] = mapper.readValue(jsonData, User[].class);

            return Users;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/
        return new User[0];
    }

}
