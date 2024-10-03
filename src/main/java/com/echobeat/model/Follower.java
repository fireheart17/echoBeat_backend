package com.echobeat.model;

public class Follower {
    private long artist_id;
    private long user_id;

    // Default constructor
    public Follower() {}

    // Constructor to set values for all variables
    public Follower(long artist_id, long user_id) {
        this.artist_id = artist_id;
        this.user_id = user_id;
    }

    // Getter and Setter for artist_id
    public long getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(long artist_id) {
        this.artist_id = artist_id;
    }

    // Getter and Setter for user_id
    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}
