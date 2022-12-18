package com.example.spacetrivia;

import android.content.ClipData;
import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {

    Context context;
    List<NasaImage> postList;

    public PostAdapter(Context context , List<NasaImage> postList){
        this.context = context;
        this.postList = postList;
    }
    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(context).inflate(R.layout.eachimage , parent , false);
        return new PostHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {

        NasaImage item= postList.get(position);
        holder.setImageView(item.getImageURL());
        holder.setTitle(item.getTitle());
        holder.setDate(item.getDate());
        holder.setDescription(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class PostHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView imagetitle, imagedescription,imagedate;
        View view;
        public PostHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;

        }

        public void setImageView(String url){
            imageView = view.findViewById(R.id.nasaImage);
            Glide.with(context).load(url).into(imageView);
        }
        public void setTitle(String title){
            imagetitle = view.findViewById(R.id.titleImage);
            imagetitle.setText(title);
        }
        public void setDate(String date){
            imagedate = view.findViewById(R.id.dateImage);
            imagedate.setText(date);
        }
        public void setDescription(String description){
            imagedescription = view.findViewById(R.id.descriptionImage);
            imagedescription.setText(description);
        }

    }
}