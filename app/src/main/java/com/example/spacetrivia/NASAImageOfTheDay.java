package com.example.spacetrivia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NASAImageOfTheDay extends AppCompatActivity {
Button button;
    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List<NasaImage> mList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nasaimage_of_the_day);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = MySingleton.getInstance(this).getRequestQueue();

        mList = new ArrayList<>();
        fetchData();
    }
    private void fetchData() {

        String url = "https://api.nasa.gov/planetary/apod?api_key=mVHP73isNjhQZroWysMhXKYtTXbS9eOUMR2I4lSl&start_date=2022-12-12";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    //JSONArray jsonArray = response.getJSONArray("hits");

                    for(int i = response.length()-1 ; i>0 ; i--){
                        JSONObject jsonObject = response.getJSONObject(i);
                        String imgurl = jsonObject.getString("url");
                        String title = jsonObject.getString("title");
                        String date = jsonObject.getString("date");
                        String description = jsonObject.getString("explanation");
                        NasaImage post = new NasaImage(title,date,imgurl,description);
                        mList.add(post);

                    }

                    PostAdapter adapter = new PostAdapter(NASAImageOfTheDay.this , mList);
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(NASAImageOfTheDay.this, "yikes", Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(jsonArrayRequest);
    }

}