package com.echobeat.model;

public class Ranking {
    private long track_id;
    private long chart_id;
    private long rank_val;


    public Ranking() {

    }

    public Ranking(long chart_id,long rank_val) {
        this.chart_id = chart_id;
        this.rank_val = rank_val;
    }


    // Getter and Setter for rank_id
    public long getTrack_id() {
        return track_id;
    }

    public void setTrack_id(long rank_id) {
        this.track_id = rank_id;
    }

    // Getter and Setter for chart_id
    public long getChart_id() {
        return chart_id;
    }

    public void setChart_id(long chart_id) {
        this.chart_id = chart_id;
    }

    // Getter and Setter for rank
    public long getRank_val() {
        return rank_val;
    }

    public void setRank_val(long rank_val) {
        this.rank_val = rank_val;
    }

}