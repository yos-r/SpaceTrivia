package com.example.spacetrivia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class AboutUs extends AppCompatActivity {
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        viewPager = (ViewPager) findViewById(R.id.viewpagertoo);
        AboutUsSliderAdapter myadapter = new AboutUsSliderAdapter(this);
        viewPager.setAdapter(myadapter);
    }
}