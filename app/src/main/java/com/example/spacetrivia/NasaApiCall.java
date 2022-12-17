package com.example.spacetrivia;
import android.content.Context;
import android.widget.Toast;

import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NasaApiCall {
    public static final String URL="https://api.nasa.gov/planetary/apod?api_key=mVHP73isNjhQZroWysMhXKYtTXbS9eOUMR2I4lSl";
    Context context;
    // constructor
    public NasaApiCall(Context c){
        this.context=c;
    }
    public interface VolleyResponseListener{
        void onError(String msg);
        void onResponse(String imgurl);
    }
    public void getImageOfTheDay(VolleyResponseListener vrp){
        String url=URL;
        JsonObjectRequest jsonRequest= new JsonObjectRequest(url,response -> {
            String title = null;
            String iotd =null;
            try {
//                JSONObject object= response.getJSONObject("")
//                JSONArray array= response.getJSONArray("results");
//                JSONObject firstresult =array.getJSONObject(0); //grab the first result {}
//                id=firstresult.getLong("id"); // grab the first result's id
//                population=firstresult.getLong("population"); // and population
//                country=firstresult.getString("country"); //and country
//                 iotd = response.getString("url");
                 title = response.getString("title");
            } catch (JSONException e) {
                e.printStackTrace();
            }
//            Toast.makeText(context, title +" ", Toast.LENGTH_SHORT).show();
            //implement the onResponse method
            vrp.onResponse(title); //grabs the returned value

        }
                ,error ->{ Toast.makeText(context, "yikes man ..", Toast.LENGTH_SHORT).show();
                            vrp.onError("this didn't work");});
        MySingleton.getInstance(context).addToRequestQueue(jsonRequest); //Handles all requests sequentially~~

    }

}
