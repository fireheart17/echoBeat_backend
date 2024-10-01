package com.echobeat.echobeat.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.echobeat.echobeat.model.LikedAlbums;
public interface LikedAlbumsRepository extends JpaRepository<LikedAlbums,Long>
{
	// crud
}