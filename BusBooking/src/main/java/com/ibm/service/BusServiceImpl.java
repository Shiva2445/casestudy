package com.ibm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Bus;
import com.ibm.repo.BusRepository;
@Service
public class BusServiceImpl implements BusService {
	@Autowired
	BusRepository repo;
	@Override
	public int save(Bus f) {
		repo.save(f);
		return f.getBusnumber();
	}

	@Override
	public Bus fetch(int busnumber) {
		
		return repo.findById(busnumber).get();
	}

	@Override
	public List<Bus> list() {
		
		return repo.findAll();
	}

	@Override
	public boolean remove(int busnumber) {
		repo.deleteById(busnumber);
		return true;
	}

	@Override
	public boolean update(Bus f) {
		repo.save(f);
		return false;
	}

	@Override
	public List<Bus> byBusname(String busname) {
		
		return repo.findByBusname(busname);
	}

	@Override
	public List<Bus> byRoute(String source, String destination) {
		
		return repo.findByRoute(source, destination);
	}

	
	
}
