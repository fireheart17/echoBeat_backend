package com.echobeat.repository;

import com.echobeat.model.LikedPlaylists;

public interface LikedPlaylistsInterface {
    int saveLikedPlaylist(LikedPlaylists likedPlaylists);
    // int updateLikedPlaylist(LikedPlaylists likedPlaylists);
    int deleteLikedPlaylist(long userId, long playlistId);
    boolean findLikedPlaylist(long userId, long playlistId);
}
