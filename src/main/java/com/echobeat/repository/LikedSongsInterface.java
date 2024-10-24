package com.echobeat.repository;

import java.util.List;

import com.echobeat.model.LikedSongs;
import com.echobeat.model.Track;

public interface LikedSongsInterface {
    int save(LikedSongs likedSongs);
    int update(LikedSongs likedSongs);
    int delete(long userId, String trackId);
    List<LikedSongs> findByTrackId(String trackId);
    List<Track> findByUserId(long userId);
}