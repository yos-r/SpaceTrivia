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
        questions.add(new Question("What is the age of the universe?","6000 years","13.7 billion years old","1 million years","13.7 billion years old",R.drawable.universetoo));
        questions.add(new Question("What is at the center of the Milky Way galaxy?","The sun","A black hole","Omuamua","A black hole",R.drawable.blackhole));
        questions.add(new Question("How many planets are in the Solar System?","Eight planets","Nine planets","Ten planets","Eight planets",R.drawable.planetstoo));
        questions.add(new Question("Which planet has the largest ocean?","Mars","Earth","Jupiter","Jupiter",R.drawable.jupiter));
        questions.add(new Question("Which is the densest planet in our solar system?","Venus","Saturn","Earth","Earth",R.drawable.earth));
        questions.add(new Question("Who was the first person to travel into space? ","Yuri Gagarin","Neil Armstrong","Alan shepard","Yuri Gagarin",R.drawable.astronaut));
        questions.add(new Question("How long does it take the sun’s rays to reach Earth? ","15 minutes","8 minutes","1 minute","8 minutes",R.drawable.sunicon));
        questions.add(new Question("Which planet is closest in size to Earth?","Venus","Mercury","Mars","Venus",R.drawable.venus));
        questions.add(new Question("What accounts for approximately 85% of the matter in the universe?","Dark energy","Dark matter","Normal matter","Dark matter",R.drawable.universetoo));
        questions.add(new Question("What spacecraft visited Uranus?","Voyager 2","James Webb telescope","Pioneer 10","Voyager 2",R.drawable.spacecraft));
        questions.add(new Question("What do you call a large number of meteoroids occurring at the same time and place?","A meteor shower","A coronal mass ejection","A pulsar","A meteor shower",R.drawable.meteroid));
        questions.add(new Question("How old is the sun?","1 billion years","6000 years","4.6 billion years","4.6 billion years",R.drawable.sunicon));
        questions.add(new Question("Which planet has the most volcanoes? ","Earth","Venus","Mars","Venus",R.drawable.volcano));
        questions.add(new Question("What protects Earth from meteoroids and radiation from the sun?","The atmosphere","The clouds","Alien spaceships","The atmosphere",R.drawable.radiation));
        questions.add(new Question("How many constellations are there?","Millions","88","Ten thousand","88",R.drawable.constellation));
        questions.add(new Question("Where is the coldest place in the universe?","The boomerang Nebula","Pluto","Neptune","The boomerang Nebula",R.drawable.nebula));
        questions.add(new Question("What is the unit of measurement used to describe the expansion of the universe?","Newton","The Hubble constant","Light years","The Hubble constant",R.drawable.universetoo));
        questions.add(new Question("Which one of these planets doesn't have a ring around them?","Saturn","Neptune","Mercury","Mercury",R.drawable.mercury));
        questions.add(new Question("Which is the oldest planet in our solar system?","Jupiter","Neptune","Mars","Jupiter",R.drawable.jupiter));
        questions.add(new Question("Who was the first person to walk on the moon?","Valentina Tereshkova","Yuri Gagarin","Neil Armstrong","Neil Armstrong",R.drawable.astronautman));

    }

}