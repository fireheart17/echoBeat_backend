package com.echobeat.model;

public class LikedPlaylists {
    private long user_id;
    private long playlist_id;

    public LikedPlaylists() {}

    // Explicit constructor
    public LikedPlaylists(long user_id, long playlist_id) {
        this.user_id = user_id;
        this.playlist_id = playlist_id;
    }

    // Getter and Setter for user_id
    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    // Getter and Setter for playlist_id
    public long getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(long playlist_id) {
        this.playlist_id = playlist_id;
    }
}
