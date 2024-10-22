package com.echobeat.model;

public class CreatedAlbum {
    private long album_id;
    private long artist_id;

    public CreatedAlbum(){

    }

    public CreatedAlbum(long album_id,long artist_id){
        this.album_id=album_id;
        this.artist_id=artist_id;
    }

    public long getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(long artist_id) {
        this.artist_id = artist_id;
    }

    // Getter and Setter for album_id
    public long getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(long album_id) {
        this.album_id = album_id;
    }
}

