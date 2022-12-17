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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        Intent intent=this.getIntent();
        TextView tv1=(TextView) findViewById(R.id.username);
        spacefacts= (Button) findViewById(R.id.spacefacts);
        nasaiotd= (Button) findViewById(R.id.nasaiotd);
        tv1.setText(intent.getStringExtra("username"));
        final NasaApiCall apicall= new NasaApiCall(Homescreen.this);

        spacefacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SpaceFacts.class);
                startActivity(intent);
            }
        });
        nasaiotd.setOnClickListener(view -> {
            Intent i = new Intent(this,NASAImageOfTheDay.class);
            NasaApiCall.VolleyResponseListener vrp= new NasaApiCall.VolleyResponseListener() {
                @Override
                public void onError(String msg) {
                    Toast.makeText(Homescreen.this,"yikes",Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onResponse(String title) {
//                    Toast.makeText(Homescreen.this,"title of image is"+title,Toast.LENGTH_SHORT).show();
                    i.putExtra("title",title);
                }
            };
            apicall.getImageOfTheDay(vrp);
            startActivity(i);
        });
    }

}