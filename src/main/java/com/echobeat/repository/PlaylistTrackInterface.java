package com.echobeat.repository;

import java.util.List;

import com.echobeat.model.PlaylistTrack;
import com.echobeat.model.Track;


public interface PlaylistTrackInterface {
    int save(PlaylistTrack playlistTrack);

    int delete(long playlistId, String trackId);

    List<Track> findByPlaylistId(long playlistId);
    List<PlaylistTrack> findByTrackId(String trackId);
}