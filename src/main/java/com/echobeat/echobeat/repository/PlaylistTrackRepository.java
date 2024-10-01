package com.echobeat.echobeat.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.echobeat.echobeat.model.PlaylistTrack;
public interface PlaylistTrackRepository extends JpaRepository<PlaylistTrack,Long>
{
	// crud
}