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

public class AboutUsSliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;
    public AboutUsSliderAdapter(Context context) {
        this.context = context;
    }
    // list of images
    public int[] lst_images = {
            R.drawable.image_1,
            R.drawable.saturn,
            R.drawable.moon,
            R.drawable.resources
    };
    // list of titles
    public String[] lst_title = {
            "About the project",
            "Yosr Barghouthi",
            "Maissa Dridi",
            "Resources",

    }   ;
    // list of descriptions
    public String[] lst_description = {
            "Course: Mobile development \n Fall 2022. \n Swipe left to know the creators",
            "yosrbargouti@gmail.com \n Favorite planet: Saturn. ",
            "maissadridi1@gmail.com \n Favorite satellite: the moon.",
            "Font: Minecraft official font \n " +
                    "Music: Another World by Colleen \n"+
                    "Images: icon-icons.com\n"+"" +
                    "API: Astronomy picture of the day by NASA"

    };
    // list of background colors
    public int[]  lst_backgroundcolor = {
            Color.rgb(55,55,55),
            Color.rgb(239,85,85),
            Color.rgb(110,49,89),
            Color.rgb(239,85,85),

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
