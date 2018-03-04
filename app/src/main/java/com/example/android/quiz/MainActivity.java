package com.example.android.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //username view declaration
    EditText usernameField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the view
        usernameField = findViewById(R.id.username);

    }

    public void startGame(View view) {
        //Value in textField
        String username = usernameField.getText().toString();
        if(username.length() != 0){
            Intent intent = new Intent(this,QuizActivity.class);
            intent.putExtra("playerName",username);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Please enter your name",Toast.LENGTH_LONG).show();
        }

    }
}
