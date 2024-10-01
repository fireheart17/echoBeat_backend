package com.echobeat.echobeat.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.echobeat.echobeat.model.Employee;
public interface EmployeeRepository extends JpaRepository<Employee,Long>
{
	// crud
}