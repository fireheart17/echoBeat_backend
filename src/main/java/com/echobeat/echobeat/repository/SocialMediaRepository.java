package com.echobeat.echobeat.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.echobeat.echobeat.model.SocialMedia;
public interface SocialMediaRepository extends JpaRepository<SocialMedia,Long>
{
	// crud
}