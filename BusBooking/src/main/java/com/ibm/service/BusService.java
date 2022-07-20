package com.ibm.service;

import java.util.List;

import com.ibm.entity.Bus;

public interface BusService {
	
		int save(Bus f);

		Bus fetch(int busnumber);

		List<Bus> list();

		boolean remove(int busnumber);

		boolean update(Bus f);
		
		List<Bus> byBusname(String busname);
		
		List<Bus> byRoute(String source, String destination);
	
}
