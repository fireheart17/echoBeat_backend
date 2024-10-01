package com.echobeat.echobeat.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.echobeat.echobeat.model.User;
public interface UserRepository extends JpaRepository<User,Long>
{
	// crud
}