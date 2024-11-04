package com.echobeat.repository;

import java.util.List;

import com.echobeat.model.LikedPodcasts;
import com.echobeat.model.Podcast;

public interface LikedPodcastsInterface {
    int addLikedPodcast(LikedPodcasts likedPodcast);
    int removeLikedPodcast(long user_id, long podcast_id);
    List<Podcast> findLikedPodcastsByUserId(long userId);
}
