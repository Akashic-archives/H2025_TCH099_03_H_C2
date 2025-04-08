package com.example.liarschess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PastGameActivity extends AppCompatActivity implements View.OnClickListener {

    private Button PastGameButtonReturn;

    ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_game);

        //PastGameButtonReturn = (Button) findViewById(R.id.PastGameButtonReturn);

        PastGameButtonReturn.setOnClickListener(this);

        activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        });

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(PastGameActivity.this, HistoryActivity.class);
        activityResultLauncher.launch(intent);
    }
}
