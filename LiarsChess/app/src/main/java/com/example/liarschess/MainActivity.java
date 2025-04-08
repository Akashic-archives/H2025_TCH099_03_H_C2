package com.example.liarschess;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "MainActivity";

    private EditText MainInputUsername, MainInputPassword;
    private Button MainButtonConnection;

    private ActivityResultLauncher<Intent> activityResultLauncher;

    private User user;
    private User users[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainInputUsername = (EditText) findViewById(R.id.MainInputUsername);
        MainInputPassword = (EditText) findViewById(R.id.MainInputPassword);
        MainButtonConnection = (Button) findViewById(R.id.LogButton);

        MainButtonConnection.setOnClickListener(this);

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {});

        }

    @Override
    public void onClick(View v) {
        if (!MainInputUsername.getText().toString().isEmpty() && !MainInputPassword.getText().toString().isEmpty()) {
            if (true) { //authentificate()) { TODO: change this to use authentificate
                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
                activityResultLauncher.launch(intent);
            } else
                Toast.makeText(MainActivity.this, "Erreur d'authentification", Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(MainActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_LONG).show();
    }

    private boolean authentificate() {

        Thread getUtilisateursThead = new Thread() {
            @Override
            public void run() {
                try {
                    users = HttpJsonClientsDao.getInstance().getUsers();
                } catch (RuntimeException e) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.e(TAG, "error", e);
                        }
                    });
                }
            }
        };

        getUtilisateursThead.start();

        for (User user: users) {
            if (user.getName().equals(MainInputUsername.getText().toString()) && user.getPassword().equals(MainInputPassword.getText().toString())) {
                return true;
            }
        }
        Toast.makeText(MainActivity.this, "Erreur d'authentification", Toast.LENGTH_LONG).show();
        return false;
    }
}
