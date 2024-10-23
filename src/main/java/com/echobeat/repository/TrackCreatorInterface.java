package com.echobeat.repository;
import java.util.List;

import com.echobeat.model.TrackCreator;

public interface TrackCreatorInterface {
    TrackCreator save(TrackCreator trackCreator);
    TrackCreator delete(String trackId, long artistId);
    void update(TrackCreator trackCreator);
    TrackCreator findByTrackIdAndArtistId(String trackId, long artistId);
    List<TrackCreator> findAll();
}

