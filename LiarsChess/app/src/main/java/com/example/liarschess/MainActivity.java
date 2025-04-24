package com.example.liarschess;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.liarschess.Daos.HttpJsonService;
import com.example.liarschess.Entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";

    private EditText MainInputEmail, MainInputPassword;
    private Button MainButtonConnection;

    private ActivityResultLauncher<Intent> HistoryActivityLauncher;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainInputEmail = (EditText) findViewById(R.id.MainInputUsername);
        MainInputPassword = (EditText) findViewById(R.id.MainInputPassword);
        MainButtonConnection = (Button) findViewById(R.id.LogButton);

        MainButtonConnection.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){logInRequest(MainInputEmail.getText().toString());}
        });
        HistoryActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        if(o.getResultCode() == RESULT_OK){
                            Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT);
                        }
                    }
                }
        );

        }

    private void logInRequest(String emailInput) {
        Intent intent = new Intent(this, MainActivity.class);

        new Thread(() -> {
            try {
                String emailEncoded = URLEncoder.encode(emailInput, "UTF-8");
                final String URL = "http://10.0.2.2:3000/api/user/" + emailEncoded;

                OkHttpClient huser = new OkHttpClient();
                Request request = new Request.Builder().url(URL).build();
                Response response = huser.newCall(request).execute();
                ResponseBody responseBody = response.body();

                if (responseBody != null) {
                    String jsonStr = responseBody.string();
                    Log.d(TAG, "Server Output : " + jsonStr);
                    ObjectMapper mapper = new ObjectMapper();
                    String[] password = mapper.readValue(jsonStr, String[].class);
                    Log.d(TAG, "Target Client :" + Arrays.toString(password));

                    if (password.length == 0) {
                        runOnUiThread(() -> Toast.makeText(MainActivity.this, "Wrong Email", Toast.LENGTH_SHORT).show());
                        return;
                    }


                    String passwdInput = MainInputPassword.getText().toString();
                    if (password.equals(passwdInput)) {
                        intent.putExtra("ID_USER", user.getEmail());
                        runOnUiThread(() -> HistoryActivityLauncher.launch(intent));
                    } else {
                        runOnUiThread(() -> Toast.makeText(MainActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show());
                    }
                }
            } catch (IOException e) {
                Log.e(TAG, "Network error", e);
                runOnUiThread(() -> Toast.makeText(MainActivity.this, "Connection Error", Toast.LENGTH_SHORT).show());
            }
        }).start();
    }
}
