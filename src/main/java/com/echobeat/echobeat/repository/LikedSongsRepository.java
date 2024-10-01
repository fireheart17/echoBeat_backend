package com.echobeat.echobeat.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.echobeat.echobeat.model.LikedSongs;
public interface LikedSongsRepository extends JpaRepository<LikedSongs,Long>
{
	// crud
}