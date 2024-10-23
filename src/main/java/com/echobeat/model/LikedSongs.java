package com.echobeat.model;

public class LikedSongs {
    private long user_id;
    private String track_id;

    public LikedSongs() {
    }

    public LikedSongs(long user_id, String track_id) {
        this.user_id = user_id;
        this.track_id = track_id;
    }

    // Getter for userId
    public long getUser_id() {
        return user_id;
    }

    // Setter for userId
    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    // Getter for trackId
    public String getTrack_id() {
        return track_id;
    }

    // Setter for trackId
    public void setTrack_id(String track_id) {
        this.track_id = track_id;
    }
}