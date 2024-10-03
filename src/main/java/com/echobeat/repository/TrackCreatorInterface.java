package com.echobeat.repository;
import java.util.List;

import com.echobeat.model.TrackCreator;

public interface TrackCreatorInterface {
    TrackCreator save(TrackCreator trackCreator);
    TrackCreator delete(long trackId, long artistId);
    void update(TrackCreator trackCreator);
    TrackCreator findByTrackIdAndArtistId(long trackId, long artistId);
    List<TrackCreator> findAll();
}

