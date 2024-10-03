package com.echobeat.repository;

import java.util.List;

import com.echobeat.model.PlaylistTrack;

public interface PlaylistTrackInterface {
    int save(PlaylistTrack playlistTrack);

    int delete(long playlistId, long trackId);

    List<PlaylistTrack> findByPlaylistId(long playlistId);

    List<PlaylistTrack> findByTrackId(long trackId);
}