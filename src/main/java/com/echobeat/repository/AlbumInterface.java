package com.echobeat.repository;
import java.util.*;
import com.echobeat.model.Album;

public interface AlbumInterface {

    int save(Album album);

    int update(Album album);

    int deleteById(long album_id);

    Album findById(long album_id);

    List<Album> search(String keyword);

}
