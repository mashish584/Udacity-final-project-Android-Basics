package com.example.android.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_activity);

        TextView finalScore = findViewById(R.id.playerScore);
        TextView status = findViewById(R.id.status);

        Intent intent = getIntent();
        String score = intent.getStringExtra("finalScore");
        String quizStatus = intent.getStringExtra("status");
        finalScore.setText(score);
        status.setText(quizStatus);

    }

    @Override
    public void onBackPressed() {
        goToMain();
    }

    public void replayGame(View view) {
        goToMain();
    }

    private void goToMain() {
        Intent intent  = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
