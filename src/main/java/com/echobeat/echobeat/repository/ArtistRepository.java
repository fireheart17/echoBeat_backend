package com.echobeat.echobeat.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.echobeat.echobeat.model.Artist;
public interface ArtistRepository extends JpaRepository<Artist,Long>
{
	// crud
}