package com.echobeat.echobeat.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.echobeat.echobeat.model.PodcastCreator;
public interface PodcastCreatorRepository extends JpaRepository<PodcastCreator,Long>
{
	// crud
}