package com.example.spacetrivia;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SpaceQuiz extends AppCompatActivity {
    private TextView attemptstextview,questiontextview;
    private ImageView imagequestion;
    private Button option1,option2,option3;
    private ArrayList<Question> questions;
    int score=0,attempts=1,currentquestion=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_quiz);
        questiontextview= (TextView) findViewById(R.id.question);
        attemptstextview= (TextView) findViewById(R.id.header);
        option1= findViewById(R.id.option1);
        option2=findViewById(R.id.option2);
        option3=findViewById(R.id.option3);
        imagequestion=(ImageView) findViewById(R.id.imagequestion);
        questions= new ArrayList<>();
        getQuestion(questions);
        updateQuestions(currentquestion);
        option1.setOnClickListener(view->{
            if (questions.get(currentquestion).getAnswer().equals(option1.getText().toString())){
                score++;

            };
            attempts++;
            currentquestion++;
            updateQuestions(currentquestion);
        });
        option2.setOnClickListener(view->{
            if (questions.get(currentquestion).getAnswer().equals(option2.getText().toString())){
                score++;
            };
            attempts++;
            currentquestion++;
            updateQuestions(currentquestion);

        });
        option3.setOnClickListener(view->{
            if (questions.get(currentquestion).getAnswer().equals(option3.getText().toString())){
                score++;
            };
            attempts++;
            currentquestion++;
            updateQuestions(currentquestion);
        });


    }
    public void updateQuestions(int currentquestion){
        if (currentquestion>=questions.size()){
            Intent i= new Intent(this,ScoreActivity.class);
            i.putExtra("score",score);
            startActivity(i);
        }
        else {
            attemptstextview.setText("Question " + attempts + "/20");
            questiontextview.setText(questions.get(currentquestion).getQuestion());
            option1.setText(questions.get(currentquestion).getOption1());
            option2.setText(questions.get(currentquestion).getOption2());
            option3.setText(questions.get(currentquestion).getOption3());
            imagequestion.setImageResource(questions.get(currentquestion).getImage());
        }
    }
    public void getQuestion(ArrayList<Question> questions){
        questions.add(new Question("What is the age of the universe?","6000 years","13.7 billion years old","1 million years","13.7 billion years old",R.drawable.jupiter));
        questions.add(new Question("What is at the center of the Milky Way galaxy?","The sun","A black hole","Omuamua","A black hole",R.drawable.blackhole));
    }

}