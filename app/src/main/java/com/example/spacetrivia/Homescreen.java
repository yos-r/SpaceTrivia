package com.example.spacetrivia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Homescreen extends AppCompatActivity {
    Button spacefacts;
    Button nasaiotd;
    Button aboutus;
    Button startquiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        Intent intent=this.getIntent();
        TextView tv1=(TextView) findViewById(R.id.username);
        spacefacts= (Button) findViewById(R.id.spacefacts);
        nasaiotd= (Button) findViewById(R.id.nasaiotd);
        aboutus=(Button) findViewById(R.id.aboutus);
        startquiz= (Button) findViewById(R.id.startquiz);
        tv1.setText(intent.getStringExtra("username"));

        spacefacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SpaceFacts.class);
                startActivity(intent);
            }
        });
        nasaiotd.setOnClickListener(view -> {
            Intent i = new Intent(this,NASAImageOfTheDay.class);
            startActivity(i);
        });
        aboutus.setOnClickListener(view->{
            Intent i= new Intent(this, AboutUs.class);
            startActivity(i);
        });
        startquiz.setOnClickListener(view->{
            Intent i = new Intent(this,SpaceQuiz.class);
            startActivity(i);
        });

    }

}