package com.echobeat.repository;
import com.echobeat.model.Artist;

public interface ArtistInterface {
    int saveArtist(Artist artist);

    Artist updateArtist(Artist artist);

    Artist deleteArtist(long artistId);

    Artist findArtistById(long artistId);
}
