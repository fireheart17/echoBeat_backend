package com.echobeat.echobeat.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.echobeat.echobeat.model.LikedPlaylists;
public interface LikedPlaylistsRepository extends JpaRepository<LikedPlaylists,Long>
{
	// crud
}