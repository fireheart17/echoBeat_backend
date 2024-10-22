package com.echobeat.repository;

import com.echobeat.model.CreatedAlbum;

import com.echobeat.model.Album;

import java.util.List;

public interface CreatedAlbumInterface {

    int addCreatedAlbum(CreatedAlbum createdAlbum);

    int removeCreatedAlbum(long album_id, long artist_id);

    List<Album> getAlbumsByArtistId(long artist_id);
}
