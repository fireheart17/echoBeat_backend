package com.echobeat.model;

public class Subscription {
    
    private long subscription_id;
    private String title;
    private int price;
    private int duration;

    // Default constructor
    public Subscription() {
    }

    // Constructor with parameters
    public Subscription(long subscription_id, String title, int price, int duration) {
        this.subscription_id = subscription_id;
        this.title = title;
        this.price = price;
        this.duration = duration;
    }

    // Getter and Setter for subscription_id
    public long getSubscription_id() {
        return subscription_id;
    }

    public void setSubscription_id(long subscription_id) {
        this.subscription_id = subscription_id;
    }

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for price
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    // Getter and Setter for duration
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
