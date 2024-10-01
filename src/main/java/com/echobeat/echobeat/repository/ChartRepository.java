package com.echobeat.echobeat.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.echobeat.echobeat.model.Chart;
public interface ChartRepository extends JpaRepository<Chart,Long>
{
	// crud
}