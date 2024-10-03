package com.echobeat.repository;

import com.echobeat.model.LikedPodcasts;

public interface LikedPodcastsInterface {
    int addLikedPodcast(LikedPodcasts likedPodcast);
    int removeLikedPodcast(long user_id, long podcast_id);
}
