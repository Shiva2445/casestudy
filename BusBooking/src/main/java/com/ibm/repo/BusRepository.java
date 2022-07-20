package com.ibm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.entity.Bus;

public interface BusRepository extends JpaRepository<Bus, Integer> {
	
	List<Bus> findByBusname(String busname);
	
	//List<Bus> findBySourceAndDestination(String source, String destination);
	
	
	@Query("From Bus WHERE source=:src AND destination=:dest")
	List<Bus> findByRoute(String src,String dest);
}
