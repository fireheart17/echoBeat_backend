package com.echobeat.echobeat.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.echobeat.echobeat.model.LikedPodcasts;
public interface LikedPodcastsRepository extends JpaRepository<LikedPodcasts,Long>
{
	// crud
}