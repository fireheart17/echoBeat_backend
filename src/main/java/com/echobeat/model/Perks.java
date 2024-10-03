package com.echobeat.model;

public class Perks {
    private long subscription_id;
    private String description;

    public Perks() {

    }

    public Perks(long subscription_id, String description) {
        this.subscription_id = subscription_id;
        this.description = description;
    }

    // Getter for subscriptionId
    public long getSubscription_id() {
        return subscription_id;
    }

    // Setter for subscriptionId
    public void setSubscription_id(long subscription_id) {
        this.subscription_id = subscription_id;
    }

    // Getter for description
    public String getDescription() {
        return description;
    }

    // Setter for description
    public void setDescription(String description) {
        this.description = description;
    }
}