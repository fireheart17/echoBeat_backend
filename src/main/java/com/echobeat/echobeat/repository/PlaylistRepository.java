package com.echobeat.echobeat.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.echobeat.echobeat.model.Playlist;
public interface PlaylistRepository extends JpaRepository<Playlist,Long>
{
	// crud
}