package com.echobeat.model;

public class PlaylistTrack {
    private long playlist_id;
    private long track_id;

    public PlaylistTrack() {
    }

    public PlaylistTrack(long playlist_id, long track_id) {
        this.playlist_id = playlist_id;
        this.track_id = track_id;
    }

    // Getter for playlistId
    public long getPlaylist_id() {
        return playlist_id;
    }

    // Setter for playlistId
    public void setPlaylist_id(long playlist_id) {
        this.playlist_id = playlist_id;
    }

    // Getter for trackId
    public long getTrack_id() {
        return track_id;
    }

    // Setter for trackId
    public void setTrack_id(long track_id) {
        this.track_id = track_id;
    }
}