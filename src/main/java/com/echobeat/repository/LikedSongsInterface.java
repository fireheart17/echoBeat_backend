package com.echobeat.repository;

import java.util.List;

import com.echobeat.model.LikedSongs;

public interface LikedSongsInterface {
    int save(LikedSongs likedSongs);
    int update(LikedSongs likedSongs);
    int delete(long userId, String trackId);
    List<LikedSongs> findByTrackId(String trackId);
    List<LikedSongs> findByUserId(long userId);
}