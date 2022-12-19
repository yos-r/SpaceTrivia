package com.example.spacetrivia;

import android.content.Context;
import android.graphics.Color;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;
    public SlideAdapter(Context context) {
        this.context = context;
    }
    // list of images
    public int[] lst_images = {
            R.drawable.factsintro,
            R.drawable.universe,
            R.drawable.blackhole,
            R.drawable.jupiter,
            R.drawable.earth,
            R.drawable.planetstoo,
            R.drawable.astronaut,
            R.drawable.sunicon,
            R.drawable.venus,
            R.drawable.universetoo,
            R.drawable.spacecraft,
            R.drawable.meteroid,
            R.drawable.sunicon,
            R.drawable.volcano,
            R.drawable.radiation,
            R.drawable.constellation,
            R.drawable.nebula,
            R.drawable.universetoo,
            R.drawable.mercury,
            R.drawable.jupiter,
            R.drawable.astronautman

    };
    // list of titles
    public String[] lst_title = {
            "Here are some space facts to prepare for the quiz",
            "What is the age of the universe?",
            "What is at the center of the Milky Way galaxy?",
            "Which planet has the largest ocean?",
            "Which is the densest planet in our solar system?",
            "How many planets are in the Solar System?",
            "Who was the first person to travel into space?",
            "How long does it take the sun’s rays to reach Earth? ",
            "Which planet is closest in size to Earth?",
            "What accounts for approximately 85% of the matter in the universe?",
            "What spacecraft visited Uranus?",
            "What do you call a large number of meteoroids occurring at the same time and place?",
            "How old is the sun?",
            "Which planet has the most volcanoes?",
            "What protects Earth from meteoroids and radiation from the sun?",
            "How many constellations are there?",
            "Where is the coldest place in the universe?",
            "What is the unit of measurement used to describe the expansion of the universe?",
            "Which one of these planets doesn't have a ring around it?",
            "Which is the oldest planet in our solar system?",
            "Who was the first person to walk on the moon?"
    }   ;
    // list of descriptions
    public String[] lst_description = {
            "Swipe left to discover the facts ! ⬅️ ",
            "13.7 billion years old",
            "A black hole",
            "Jupiter",
            "Earth",
            "Eight Planets",
            "Yuri Gagarin",
            "8 minutes",
            "Venus",
            "Dark Matter",
            "Voyager 2",
            "A meteor shower",
            "4.6 billion years",
            "Venus",
            "The atmosphere",
            "88",
            "The boomerang Nebula",
            "The Hubble constant",
            "Mercury",
            "Jupiter",
            "Neil Armstrong"
    };
    // list of background colors
    public int[]  lst_backgroundcolor = {
            Color.rgb(1,188,212),
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212),
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212),
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212),
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212),
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(1,188,212),

    };



    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slidelinearlayout);
        ImageView imgslide = (ImageView)  view.findViewById(R.id.slideimg);
        TextView txttitle= (TextView) view.findViewById(R.id.txttitle);
        TextView description = (TextView) view.findViewById(R.id.txtdescription);
        layoutslide.setBackgroundColor(lst_backgroundcolor[position]);
        imgslide.setImageResource(lst_images[position]);
        txttitle.setText(lst_title[position]);
        description.setText(lst_description[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}