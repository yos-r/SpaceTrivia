package com.example.spacetrivia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;


import android.os.Bundle;

public class SpaceFacts extends AppCompatActivity {
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_facts);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        SlideAdapter myadapter = new SlideAdapter(this);
        viewPager.setAdapter(myadapter);
    }
}