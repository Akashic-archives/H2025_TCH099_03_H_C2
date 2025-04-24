package com.example.liarschess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class HistoryActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView HistoryListGames;
    private Button HistoryButtonNext;

    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);



        HistoryListGames = (ListView) findViewById(R.id.gameList);
        HistoryButtonNext = (Button) findViewById(R.id.LogOutButton);


        HistoryButtonNext.setOnClickListener();

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {});

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(HistoryActivity.this, PastGameActivity.class);
        activityResultLauncher.launch(intent);
    }
}