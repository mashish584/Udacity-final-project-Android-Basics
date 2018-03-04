package com.example.android.quiz;

import java.util.ArrayList;

/**
 * Created by Ashish on 2/27/2018.
 */

public class Quiz {

    private String playerName;
    private int score;
    private  ArrayList<Questions> questions = new ArrayList<Questions>();

    Quiz(String name){


        this.playerName = name;
        this.score = 0;

        int[] choice1 = new int[4];

        //Question One
        choice1[0] = R.string.ques_one_choice_one;
        choice1[1] = R.string.ques_one_choice_two;
        choice1[2] = R.string.ques_one_choice_three;
        choice1[3] = R.string.ques_one_choice_four;
        questions.add(new Questions(R.string.ques_one,R.string.ques_one_ans,choice1));

        int[] choice2 = new int[4];
        //Question Two
        choice2[0] = R.string.ques_two_choice_one;
        choice2[1] = R.string.ques_two_choice_two;
        choice2[2] = R.string.ques_two_choice_three;
        choice2[3] = R.string.ques_two_choice_four;
        questions.add(new Questions(R.string.ques_two,R.string.ques_two_ans,choice2));

        int[] choice3 = new int[4];
        //Question Three
        choice3[0] = R.string.ques_three_choice_one;
        choice3[1] = R.string.ques_three_choice_two;
        choice3[2] = R.string.ques_three_choice_three;
        choice3[3] = R.string.ques_three_choice_four;
        questions.add(new Questions(R.string.ques_three,R.string.ques_three_ans,choice3));

        int[] choice4 = new int[4];
        //Question Four
        choice4[0] = R.string.ques_four_choice_one;
        choice4[1] = R.string.ques_four_choice_two;
        choice4[2] = R.string.ques_four_choice_three;
        choice4[3] = R.string.ques_four_choice_four;
        questions.add(new Questions(R.string.ques_four,R.string.ques_four_ans,choice4));

        int[] choice5 = new int[4];
        //Question Five
        choice5[0] = R.string.ques_five_choice_one;
        choice5[1] = R.string.ques_five_choice_two;
        choice5[2] = R.string.ques_five_choice_three;
        choice5[3] = R.string.ques_five_choice_four;
        questions.add(new Questions(R.string.ques_five,R.string.ques_five_ans,choice5));

        int[] choice6 = new int[4];
        //Question Six
        choice6[0] = R.string.ques_six_choice_one;
        choice6[1] = R.string.ques_six_choice_two;
        choice6[2] = R.string.ques_six_choice_three;
        choice6[3] = R.string.ques_six_choice_four;
        questions.add(new Questions(R.string.ques_six,R.string.ques_six_ans,choice6));

    }


    public String getPlayerName() {
        return playerName;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int score){
        this.score += score;
    }

    public ArrayList<Questions> getQuestions() {
        return questions;
    }


}
