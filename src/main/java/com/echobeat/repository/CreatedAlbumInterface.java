package com.echobeat.repository;

import java.util.List;

import com.echobeat.model.Album;
import com.echobeat.model.Artist;
import com.echobeat.model.CreatedAlbum;

public interface CreatedAlbumInterface {

    int addCreatedAlbum(CreatedAlbum createdAlbum);

    int removeCreatedAlbum(long album_id, long artist_id);

    List<Album> getAlbumsByArtistId(long artist_id);
    
    List<Artist> getArtistsByAlbumId(long album_id);
}
