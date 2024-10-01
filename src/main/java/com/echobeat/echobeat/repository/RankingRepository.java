package com.echobeat.echobeat.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.echobeat.echobeat.model.Ranking;
public interface RankingRepository extends JpaRepository<Ranking,Long>
{
	// crud
}