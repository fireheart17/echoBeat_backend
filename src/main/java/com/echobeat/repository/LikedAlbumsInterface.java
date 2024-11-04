package com.echobeat.repository;

import java.util.List;

import com.echobeat.model.Album;
import com.echobeat.model.LikedAlbums;

public interface LikedAlbumsInterface {
    int addLikedAlbum(LikedAlbums likedAlbum);
    int removeLikedAlbum(long user_id, long album_id);
    List<Album> LikedAlbumsByUserId(long userId);
}
