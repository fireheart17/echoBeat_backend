package com.echobeat.model;

public class PodcastCreator {
    private Long podcast_id;
    private Long artist_id;

    public PodcastCreator(){

    }

    public PodcastCreator(Long podcast_id,Long artist_id){
        this.podcast_id = podcast_id;
        this.artist_id = artist_id;
    }

    public long getPodcast_id() {
        return podcast_id;
    }

    // Setter for podcast_id
    public void setPodcast_id(long podcast_id) {
        this.podcast_id = podcast_id;
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
