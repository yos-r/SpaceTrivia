package com.example.spacetrivia;

public class NasaImage {
    private String title;
    private String date;
    private String imageURL;
    private String description;
    public NasaImage(String title,String date,String imageURL,String description){
        this.title=title;
        this.date=date;
        this.imageURL=imageURL;
        this.description=description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
