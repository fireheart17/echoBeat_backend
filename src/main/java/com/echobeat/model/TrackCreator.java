package com.echobeat.model;

public class TrackCreator {
    private Long track_id;
    private Long artist_id;

    public TrackCreator(){

    }

    public TrackCreator(Long track_id,Long artist_id){
        this.track_id = track_id;
        this.artist_id = artist_id;
    }

    public long getTrack_id() {
        return track_id;
    }

    // Setter for track_id
    public void setTrack_id(long track_id) {
        this.track_id = track_id;
    }

    // Getter for artist_id
    public long getArtist_id() {
        return artist_id;
    }

    // Setter for artist_id
    public void setArtist_id(long artist_id) {
        this.artist_id = artist_id;
    }
}
