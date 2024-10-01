package com.echobeat.echobeat.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.echobeat.echobeat.model.Podcast;
public interface PodcastRepository extends JpaRepository<Podcast,Long>
{
	// crud
}