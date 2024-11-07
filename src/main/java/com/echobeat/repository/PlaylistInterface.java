package com.echobeat.repository;

import java.util.List;
import com.echobeat.model.Playlist;

public interface PlaylistInterface {
    int save(Playlist playlist);

    int update(Playlist playlist);

    int delete(long playlistId);

    Playlist findByPlaylistId(long playlistId);

    List<Playlist> findByUserId(long userId);

    List<Playlist> search(String keyword);

    int incrementListenCount(long playlistId);
}