package com.example.android.quiz;


/**
 * Created by Ashish on 2/27/2018.
 */

public class Questions {

    private int question;
    private int answer;
    private int[] choices = new int[4];

    Questions(int question,int answer,int[] choices){
        this.question = question;
        this.answer = answer;
        this.choices = choices;
    }

    public int getQuestion() {
        return question;
    }

    public int getAnswer() {
        return answer;
    }

    public int getChoices(int index) {
        return choices[index];
    }
}
