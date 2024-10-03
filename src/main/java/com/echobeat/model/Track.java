package com.echobeat.model;

public class Track {

    private String track_id;

    private String track_name;
    private String genre;
    private String lyrics;
    private int duration;
    private String country;
    
    private int like_count;
    
    private int listen_count;

    private long album_id;

    // Default constructor
    public Track() {}

    // Parameterized constructor
    public Track(String track_id, String track_name, String genre, String lyrics, int duration, String country, int like_count, int listen_count, long album_id) {
        this.track_id = track_id;
        this.track_name = track_name;
        this.genre = genre;
        this.lyrics = lyrics;
        this.duration = duration;
        this.country = country;
        this.like_count = like_count;
        this.listen_count = listen_count;
        this.album_id = album_id;
    }

    // Getters and Setters
    public String getTrack_id() {
        return track_id;
    }

    public void setTrack_id(String track_id) {
        this.track_id = track_id;
    }

    public String getTrack_name() {
        return track_name;
    }

    public void setTrack_name(String track_name) {
        this.track_name = track_name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public int getListen_count() {
        return listen_count;
    }

    public void setListen_count(int listen_count) {
        this.listen_count = listen_count;
    }

    public long getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(long album_id) {
        this.album_id = album_id;
    }
}
