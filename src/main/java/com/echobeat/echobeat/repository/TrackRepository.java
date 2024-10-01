package com.echobeat.echobeat.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.echobeat.echobeat.model.Track;
public interface TrackRepository extends JpaRepository<Track,Long>
{
	// crud
}