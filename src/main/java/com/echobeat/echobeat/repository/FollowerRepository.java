package com.echobeat.echobeat.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.echobeat.echobeat.model.Follower;
public interface FollowerRepository extends JpaRepository<Follower,Long>
{
	// crud
}