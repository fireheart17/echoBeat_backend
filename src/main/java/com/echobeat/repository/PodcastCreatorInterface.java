package com.echobeat.repository;
import java.util.List;

import com.echobeat.model.Artist;
import com.echobeat.model.PodcastCreator;

public interface PodcastCreatorInterface {
    PodcastCreator save(PodcastCreator podcastCreator);
    PodcastCreator delete(long podcastId, long artistId);
    void update(PodcastCreator podcastCreator);
    PodcastCreator findByPodcastIdAndArtistId(long podcastId, long artistId);
    List<PodcastCreator> findAll();
    List<Artist> getArtistsByPodcastId(long podcastId);
}

