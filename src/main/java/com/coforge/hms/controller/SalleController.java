package com.coforge.hms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.coforge.hms.model.Salle;
import com.coforge.hms.service.SalleServiceImpl;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value="/api")
public class SalleController {
	@Autowired
    private SalleServiceImpl sService;
	@PostMapping("/salle")
	public Salle addSalle(@RequestBody Salle s) {
		return sService.save(s);
	}
	@GetMapping("/salles")
	public List<Salle>getAllSalle(){
		return sService.findAll();
	}
	@PostMapping("/salleupdate/{id}")
	public Salle update(@RequestBody Salle s,@PathVariable long id) throws Exception{
		return sService.update(s, id);
	}
	@DeleteMapping("/salle/{id}")
	public Salle deleteById(@PathVariable long id) throws Exception{
		return sService.delete(id);
	}
	@GetMapping(value="/salle/{salId}")
	public Salle getById(@PathVariable long salId) throws Exception{
		Salle s=sService.getById(salId);
		return s;
	}
}
