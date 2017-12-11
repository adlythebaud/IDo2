package com.mycabbages.teamavatar.ido2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.mycabbages.teamavatar.ido2.MainActivity;
import com.mycabbages.teamavatar.ido2.R;
import com.mycabbages.teamavatar.ido2.User;

import java.util.Arrays;
import java.util.List;

public class CoupleQuiz extends AppCompatActivity {
    static final String TAG = "quiz_log";
    private int questionNumber = 0;
    private double quizScore = 0;
    List questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_couple_quiz);
        String[] questions = new String[]{
                "I share deeply personal information about myself with my spouse.",
                "I find myself thinking about my spouse during the day.",
                "Because of my commitment to my spouse, I would not let others come between us.",
                " I receive considerable emotional support from my spouse.",
                " My relationship with my spouse is very romantic.",
                " I expect my love for my spouse to last for the rest of my life.",
                "I communicate well with my spouse.",
                " I cannot imagine another person making me as happy as my spouse does.",
                " I will always feel a strong responsibility for my spouse.",
                " I feel that I can really trust my spouse.",
                "My relationship with my spouse is very passionate.",
                "I plan to continue my relationship with my spouse.",
                " I feel that my spouse really understands me.",
                "I would rather be with my spouse than anyone else.",
                "I have confidence in the stability of my relationship with my spouse."
        };
        questionList = Arrays.asList(questions);
        TextView quest = (TextView) findViewById(R.id.question);
        quest.setText(questionList.get(questionNumber).toString());
        TextView questNum = (TextView) findViewById(R.id.question_number);
        questNum.setText("Question " + (questionNumber + 1));



    }
    public void onClick(View view){
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        TextView quest = (TextView) findViewById(R.id.question);
        TextView questNum = (TextView) findViewById(R.id.question_number);
        questionNumber++;
        quizScore += Integer.parseInt(spinner.getSelectedItem().toString());
        Log.d(TAG,"quizScore = " + quizScore);
        if (questionNumber != 15) {
            quest.setText(questionList.get(questionNumber).toString());
            questNum.setText("Question " + (questionNumber + 1));
        }else {
            int endScore = (int)((quizScore/150)*100);
            Log.d(TAG,"endScore = " + endScore);
            User user = new User();
            user.setmQuizScore(endScore);
            Log.d(TAG,"User endScore= " + user.getmQuizScore());
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}