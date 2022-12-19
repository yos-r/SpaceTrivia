package com.example.spacetrivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {
    TextView scoreheader;
    ImageView imgscore;
    TextView descriptionstore;
    Button retakebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        Intent i =this.getIntent();
        int score= i.getIntExtra("score",0);
        scoreheader=findViewById(R.id.headerscore);
        imgscore=findViewById(R.id.imgscore);
        descriptionstore=findViewById(R.id.descriptionscore);
        retakebutton= findViewById(R.id.retakequiz);
        scoreheader.setText("You scored "+score + "/20");
        if (score<10){
            imgscore.setImageResource(R.drawable.facepalm);
            descriptionstore.setText("Yikes man, stick to earth. ");
        }
        else if (score<15 &&score>=10){
            imgscore.setImageResource(R.drawable.thonk);
            descriptionstore.setText("Okayish, but not that great. are you really cut out for space?");
        }
        else if (score >=15 && score<20){
            imgscore.setImageResource(R.drawable.meteroid);
            descriptionstore.setText("Okay rising star, keep perfecting.");
        }
        else if (score==20){
            imgscore.setImageResource(R.drawable.astronaut);
            descriptionstore.setText("Talented, brilliant, amazing, show stopping, spectacular, never the same, totally unique, never been done before.");
        }
        retakebutton.setOnClickListener(view->{
            Intent intent= new Intent(this,SpaceQuiz.class);
            startActivity(intent);
        });


    }
}