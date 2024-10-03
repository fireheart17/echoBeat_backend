package com.echobeat.repository;

import java.util.List;

import com.echobeat.model.Track;

public interface TrackInterface {
    int save(Track track);
    int update(Track track);
    int deleteById(String id);
    Track findById(String id);
    List<Track> findAll();
}
