package com.echobeat.model;
public class LikedAlbums {

    private long user_id;
    private long album_id;

    // Default constructor
    public LikedAlbums() {}

    // Parameterized constructor
    public LikedAlbums(long user_id, long album_id) {
        this.user_id = user_id;
        this.album_id = album_id;
    }

    // Getter and Setter for user_id
    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    // Getter and Setter for album_id
    public long getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(long album_id) {
        this.album_id = album_id;
    }
}
