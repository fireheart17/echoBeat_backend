package com.echobeat.echobeat.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.echobeat.echobeat.model.TrackCreator;
public interface TrackCreatorRepository extends JpaRepository<TrackCreator,Long>
{
	// crud
}