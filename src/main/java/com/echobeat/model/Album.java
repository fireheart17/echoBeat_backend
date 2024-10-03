package com.echobeat.model;

import java.time.LocalTime;

public class Album {

    private long album_id;

    private String title;
    private String genre;
    private LocalTime release_date;

    public Album() {
    }

    public Album(long album_id, String title, String genre, LocalTime release_date) {
        this.album_id = album_id;
        this.title = title;
        this.genre = genre;
        this.release_date = release_date;
    }

    public long getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(long album_id) {
        this.album_id = album_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalTime getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalTime release_date) {
        this.release_date = release_date;
    }
}
