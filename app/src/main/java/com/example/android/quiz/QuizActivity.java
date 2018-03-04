package com.example.android.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    //Quiz Structure
    private Quiz quiz;
    private ArrayList<Questions> questionsList;

    //Views Declaration
    private TextView countQues;
    private TextView question;

    private RadioButton options1;
    private RadioButton options2;
    private RadioButton options3;
    private RadioButton options4;

    private Button nextButton;
    private Button submitButton;

    //Quiz trackers
    private int count = 0;
    private int random = 0;
    private String userAnswer = "";
    private ArrayList<Integer> trackQuestion  = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //Getting views and initializing all of them
        countQues    = findViewById(R.id.questionNum);
        question     = findViewById(R.id.question);
        options1     = findViewById(R.id.choice_one);
        options2     = findViewById(R.id.choice_two);
        options3     = findViewById(R.id.choice_three);
        options4     = findViewById(R.id.choice_four);
        nextButton   = findViewById(R.id.nextButton);
        submitButton = findViewById(R.id.submitButton);

        //Get Username from intent
        Intent intent = getIntent();
        String playerName = intent.getStringExtra("playerName");
        Toast.makeText(this,"WELCOME "+ playerName,Toast.LENGTH_SHORT).show();

        //Hide Submit button
        submitButton.setVisibility(View.INVISIBLE);

        //Creating a new instance of Quiz
        quiz = new Quiz(playerName);
        questionsList = quiz.getQuestions();

        //Insert Question in a view
        insertQuestion(0);

    }


    public void nextQuestion(View view) {

        resetOptions();
        calculateScore();

        if(count < questionsList.size()){
            //Generate Random number
            Random rand = new Random();
            random = rand.nextInt(questionsList.size());

            while(trackQuestion.contains(random)){
                random = rand.nextInt(questionsList.size());
            }

            if(!trackQuestion.contains(random)){
                //Insert Question in a view
                insertQuestion(random);
            }

        }

    }


    //Function for creating new question and choices
    public void insertQuestion(int index){
        question.setText(questionsList.get(index).getQuestion());
        options1.setText(questionsList.get(index).getChoices(0));
        options2.setText(questionsList.get(index).getChoices(1));
        options3.setText(questionsList.get(index).getChoices(2));
        options4.setText(questionsList.get(index).getChoices(3));
        trackQuestion.add(index);
        count++;
        //if count is equal to size of questionList
        //hide next show submit

        if(count == 6){
            nextButton.setVisibility(View.INVISIBLE);
            submitButton.setVisibility(View.VISIBLE);
        }
        //set text in question count view
        countQues.setText(count + "/" + quiz.getQuestions().size());
    }

    //Radio Buttons Handlers
    public void radioButton1Click(View view) {
        options2.setChecked(false);
        options3.setChecked(false);
        options4.setChecked(false);
        userAnswer = options1.getText().toString();
    }

    public void radioButton2Click(View view) {
        options1.setChecked(false);
        options3.setChecked(false);
        options4.setChecked(false);
        userAnswer = options2.getText().toString();
    }

    public void radioButton3Click(View view) {
        options1.setChecked(false);
        options2.setChecked(false);
        options4.setChecked(false);
        userAnswer = options3.getText().toString();
    }

    public void radioButton4Click(View view) {
        options1.setChecked(false);
        options2.setChecked(false);
        options3.setChecked(false);
        userAnswer = options4.getText().toString();
    }

    //Reset all options
    public void resetOptions() {
        options1.setChecked(false);
        options2.setChecked(false);
        options3.setChecked(false);
        options4.setChecked(false);
    }

    //function to calculate user score
    public void calculateScore() {
        if(userAnswer.equalsIgnoreCase(getString(questionsList.get(random).getAnswer()))){
            quiz.addScore(2);
        }
    }

    public void submitQuestion(View view) {
        Intent intent = new Intent(this,ScoreActivity.class);
        String score = quiz.getScore() + "";
        intent.putExtra("finalScore",score);
        intent.putExtra("status","You answered " + (quiz.getScore()/2)  + " out of " + questionsList.size()  + " questions correctly.");
        startActivity(intent);
    }
}
