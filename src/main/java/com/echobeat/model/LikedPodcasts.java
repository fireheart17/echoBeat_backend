package com.echobeat.model;
public class LikedPodcasts {


    private long user_id;
    private long podcast_id;

    // Default constructor
    public LikedPodcasts() {}

    // Parameterized constructor
    public LikedPodcasts(long user_id, long podcast_id) {
        this.user_id = user_id;
        this.podcast_id = podcast_id;
    }

    // Getter and Setter for user_id
    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    // Getter and Setter for podcast_id
    public long getPodcast_id() {
        return podcast_id;
    }

    public void setPodcast_id(long podcast_id) {
        this.podcast_id = podcast_id;
    }
}
