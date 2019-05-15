package com.example.pd4;

import java.io.Serializable;

public class menuObjects implements Serializable {

    String title;
    String image;

    public menuObjects(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public menuObjects(String title, String image) {
        this.title = title;
        this.image = image;


    }
}
