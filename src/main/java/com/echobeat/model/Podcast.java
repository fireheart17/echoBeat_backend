package com.echobeat.model;

public class Podcast {
    private long podcast_id;

    private String podcast_name;
    private String genre;
    private String lyrics;
    private int duration;
    private String country;
    private int like_count;
    private int listen_count;

    public Podcast() {

    }

    public Podcast(String podcast_name, String genre, String lyrics,
                   int duration, String country, int like_count, int listen_count) {
        this.podcast_name = podcast_name;
        this.genre = genre;
        this.lyrics = lyrics;
        this.duration = duration;
        this.country = country;
        this.like_count = like_count;
        this.listen_count = listen_count;
    }

    // Getter and Setter for podcast_id
    public long getPodcast_id() {
        return podcast_id;
    }

    public void setPodcast_id(long podcast_id) {
        this.podcast_id = podcast_id;
    }

    // Getter and Setter for podcast_name
    public String getPodcast_name() {
        return podcast_name;
    }

    public void setPodcast_name(String podcast_name) {
        this.podcast_name = podcast_name;
    }

    // Getter and Setter for genre
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Getter and Setter for lyrics
    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    // Getter and Setter for duration
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Getter and Setter for country
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // Getter and Setter for like_count
    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    // Getter and Setter for listen_count
    public int getListen_count() {
        return listen_count;
    }

    public void setListen_count(int listen_count) {
        this.listen_count = listen_count;
    }
}
