package com.echobeat.repository;
import com.echobeat.model.Artist;
import com.echobeat.model.Track;
import com.echobeat.model.Album;

import java.util.List;

public interface ArtistInterface {
    int saveArtist(Artist artist);

    Artist updateArtist(Artist artist);

    Artist deleteArtist(long artistId);

    Artist findArtistById(long artistId);

    List<Track>getTracksByArtistId(long id);

    List<Album>getAlbumsByArtistId(long id);
}
