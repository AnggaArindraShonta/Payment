package com.example.pay.model;

public class Iphone {

    private String rating;
    private String iphone_name;
    private String type;
    private String price;
    private int image;

    public Iphone() {
        this.rating = rating;
        this.iphone_name = iphone_name;
        this.type = type;
        this.price = price;
        this.image = image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getIphone_name() {
        return iphone_name;
    }

    public void setIphone_name(String iphone_name) {
        this.iphone_name = iphone_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
