package com.echobeat.repository;

import com.echobeat.model.LikedAlbums;

public interface LikedAlbumsInterface {
    int addLikedAlbum(LikedAlbums likedAlbum);
    int removeLikedAlbum(long user_id, long album_id);
}
