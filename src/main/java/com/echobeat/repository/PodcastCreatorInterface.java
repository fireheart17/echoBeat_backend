package com.echobeat.repository;
import java.util.List;

import com.echobeat.model.PodcastCreator;

public interface PodcastCreatorInterface {
    PodcastCreator save(PodcastCreator podcastCreator);
    PodcastCreator delete(long trackId, long artistId);
    void update(PodcastCreator podcastCreator);
    PodcastCreator findByTrackIdAndArtistId(long trackId, long artistId);
    List<PodcastCreator> findAll();
}

