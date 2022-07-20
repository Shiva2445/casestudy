package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Bus;
import com.ibm.service.BusService;
@CrossOrigin
@RestController
public class BusController {
	@Autowired
	private BusService service;
	@PostMapping(value ="/add", consumes ="application/json")
	public String save(@RequestBody Bus f) {
		int busnumber = service.save(f);
		return "Bus added with busnumber:" +busnumber;
	}
	
	@GetMapping(value = "/get/{busnumber}", produces = "application/json")
	public Bus fetch(int busnumber) {
		return service.fetch(busnumber);
	}

	@GetMapping(value = "/list", produces = "application/json")
	public List<Bus> list() {
		return service.list();
	}
	@DeleteMapping(value = "/del/{busnumber}")
	public String delte(@RequestParam int busnumber) {
		service.remove(busnumber);
		return "Bus deleted with busnumber "+busnumber;
	}
	@PutMapping(value ="/update", consumes = "application/json")
	public String update(@RequestBody Bus f) {
		service.update(f);
		return "Bus Updated";
	}
	@GetMapping(value ="/busname/{busname}", produces  = "application/json" )
	public List<Bus> listByBusname(@RequestParam String busname) {
		return service.byBusname(busname);
	}
	@GetMapping(value ="/route" ,produces = "application/json")
	public List<Bus> listByRoute(@RequestParam String source, @RequestParam String destination){
		return service.byRoute(source, destination);
	}

}
