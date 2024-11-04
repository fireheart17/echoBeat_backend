package com.echobeat.model;

public class Artist {
    private long artist_id;

    private String artist_name;
    private String first_name;
    private String last_name;
    private String password;
    private String global_rank;
    private String country;
    private String about;
    private int follower_count;

    public Artist() {

    }

    // Constructor to set values of all variables
    public Artist(String artist_name, String first_name, String last_name, String password, String global_rank,
            String country, String about, int follower_count) {
        this.artist_name = artist_name;
        this.first_name = first_name;
        this.last_name = last_name;
        this.password = password;
        this.global_rank = global_rank;
        this.country = country;
        this.about = about;
        this.follower_count = follower_count;
    }

    // Getter and Setter methods
    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public long getArtist_id() {
        return artist_id;
    }

    public void setArtist_id(long artist_id) {
        this.artist_id = artist_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGlobal_rank() {
        return global_rank;
    }

    public void setGlobal_rank(String global_rank) {
        this.global_rank = global_rank;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getFollower_count() {
        return follower_count;
    }

    public void setFollower_count(int follower_count) {
        this.follower_count = follower_count;
    }
}
