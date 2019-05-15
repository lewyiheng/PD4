package com.example.pd4;

import java.io.Serializable;

public class gameObjects implements Serializable {

    String name;
    String image;
    String discount;
    String price;

    public gameObjects(){

    }

    public gameObjects(String name, String image, String discount, String price) {
        this.name = name;
        this.image = image;
        this.discount = discount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
