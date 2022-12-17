package com.example.spacetrivia;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NASAImageOfTheDay extends AppCompatActivity {
Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nasaimage_of_the_day);
        button= findViewById(R.id.nasaapi);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView tv1= findViewById(R.id.textview);
        Intent i = this.getIntent();
        String title=i.getStringExtra("title");
        System.out.println(title);
        //tv1.setText(title);
//        final NasaApiCall apicall= new NasaApiCall(NASAImageOfTheDay.this);
//        NasaApiCall.VolleyResponseListener vrp= new NasaApiCall.VolleyResponseListener() {
//            @Override
//            public void onError(String msg) {
//                Toast.makeText(NASAImageOfTheDay.this,"error",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onResponse(String imgurl) {
//                Toast.makeText(NASAImageOfTheDay.this,"title of image is"+imgurl,Toast.LENGTH_SHORT).show();
//                tv1.setText(imgurl);
//            }
//        };
//        apicall.getImageOfTheDay(vrp);

//        button.setOnClickListener(view -> {
//            NasaApiCall.VolleyResponseListener vrp= new NasaApiCall.VolleyResponseListener() {
//                @Override
//                public void onError(String msg) {
//                    Toast.makeText(NASAImageOfTheDay.this,"error",Toast.LENGTH_SHORT).show();
//                }
//
//                @Override
//                public void onResponse(String imgurl) {
//                    Toast.makeText(NASAImageOfTheDay.this,"title of image is"+imgurl,Toast.LENGTH_SHORT).show();
//                }
//            };
//            apicall.getImageOfTheDay(vrp);
//        });


    }
}