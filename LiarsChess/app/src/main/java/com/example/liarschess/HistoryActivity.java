package com.example.liarschess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.liarschess.Adapters.HistoryGameListAdapter;
import com.example.liarschess.Daos.GameDao;
import com.example.liarschess.Entity.Game;

import java.util.List;

public class HistoryActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ListView HistoryListGames;
    private Button HistoryButtonNext;

    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        GameDao dao = GameDao.getInstance();

        List<Game> gameList = dao.getGames();

        HistoryGameListAdapter adapter;

        adapter = new HistoryGameListAdapter(this,R.layout.game,gameList);



        HistoryListGames = (ListView) findViewById(R.id.gameList);
        HistoryListGames.setAdapter(adapter);

        HistoryListGames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                gotogameplay();
            }
        });
        HistoryButtonNext = (Button) findViewById(R.id.LogOutButton);




        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult o) {
                        if(o.getResultCode() == RESULT_OK){
                            Toast.makeText(HistoryActivity.this,"Login Successful",Toast.LENGTH_SHORT);
                        }
                    }
                }
        );

    }

    private void gotogameplay(){
        Intent intent = new Intent(HistoryActivity.this,PastGameActivity.class);
        activityResultLauncher.launch(intent);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(HistoryActivity.this, PastGameActivity.class);
        activityResultLauncher.launch(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(HistoryActivity.this,PastGameActivity.class);
        activityResultLauncher.launch(intent);
    }
}