package com.echobeat.echobeat.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.echobeat.echobeat.model.Album;
public interface AlbumRepository extends JpaRepository<Album,Long>
{
	// crud
}