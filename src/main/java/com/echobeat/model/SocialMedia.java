package com.echobeat.model;

public class SocialMedia {
    private long artist_id;
    private String socialmediatype ;
    private String socialmediahandle;


    public SocialMedia() {

    }

    public SocialMedia (long artist_id, String socialmediatype, String socialmediahandle) {
        this.artist_id = artist_id;
        this.socialmediahandle = socialmediahandle;
        this.socialmediatype = socialmediatype;
    }

        // Getter and Setter for artist_id
        public long getArtist_id() {
            return artist_id;
        }
    
        public void setArtist_id(long artist_id) {
            this.artist_id = artist_id;
        }
    
        // Getter and Setter for socialmediatype
        public String getSocialmediatype() {
            return socialmediatype;
        }
    
        public void setSocialmediatype(String socialmediatype) {
            this.socialmediatype = socialmediatype;
        }
    
        // Getter and Setter for socialmediahandle
        public String getSocialmediahandle() {
            return socialmediahandle;
        }
    
        public void setSocialmediahandle(String socialmediahandle) {
            this.socialmediahandle = socialmediahandle;
        }
}