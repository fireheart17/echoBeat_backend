package com.echobeat.echobeat.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.echobeat.echobeat.model.Subscription;
public interface SubscriptionRepository extends JpaRepository<Subscription,Long>
{
	// crud
}