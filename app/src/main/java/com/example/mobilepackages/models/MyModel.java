package com.example.mobilepackages.models;

public class MyModel {
    private String activation;

    private String deactivation;

    private String duration;

    private int id;

    private String price;

    private String remaining;

    private String title;

    private String volume;

    public void setActivation(String activation) {
        this.activation = activation;
    }

    public void setDeactivation(String deactivation) {
        this.deactivation = deactivation;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setRemaining(String remaining) {
        this.remaining = remaining;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getActivation() {
        return activation;
    }

    public String getDeactivation() {
        return deactivation;
    }

    public String getDuration() {
        return duration;
    }

    public int getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public String getRemaining() {
        return remaining;
    }

    public String getTitle() {
        return title;
    }

    public String getVolume() {
        return volume;
    }

    public MyModel(String activation, String deactivation, String duration, int id, String price, String remaining, String title, String volume) {
        this.activation = activation;
        this.deactivation = deactivation;
        this.duration = duration;
        this.id = id;
        this.price = price;
        this.remaining = remaining;
        this.title = title;
        this.volume = volume;
    }


}
