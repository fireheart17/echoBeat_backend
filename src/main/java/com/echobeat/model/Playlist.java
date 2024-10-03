package com.echobeat.model;

public class Playlist {
    private long playlist_id;
    private String title;
    private int duration;
    private long user_id;

    public Playlist() {
    }

    public Playlist(long playlist_id, String title, int duration, long user_id) {
        this.playlist_id = playlist_id;
        this.title = title;
        this.duration = duration;
        this.user_id = user_id;
    }

    // Getter for playlistId
    public long getPlaylist_id() {
        return playlist_id;
    }

    // Setter for playlistId
    public void setPlaylist_id(long playlist_id) {
        this.playlist_id = playlist_id;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for duration
    public int getDuration() {
        return duration;
    }

    // Setter for duration
    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Getter for userId
    public long getUser_id() {
        return user_id;
    }

    // Setter for userId
    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }
}