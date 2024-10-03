package com.echobeat.repository;

import java.util.List;

import com.echobeat.model.LikedSongs;

public interface LikedSongsInterface {
    int save(LikedSongs likedSongs);
    int update(LikedSongs likedSongs);
    int delete(long userId, long trackId);
    List<LikedSongs> findByTrackId(long trackId);
    List<LikedSongs> findByUserId(long userId);
}