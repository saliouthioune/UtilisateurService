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

import com.coforge.hms.model.Batiment;
import com.coforge.hms.service.BatimentServiceImpl;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value="/api")
public class BatimentController {
	@Autowired
	private BatimentServiceImpl bService;
	@PostMapping(value="/bat")
  public Batiment save(@RequestBody Batiment bat) {
	  return bService.save(bat);
  }
	@PostMapping("/batimentupdate/{id}")	
  public Batiment update(@RequestBody Batiment bat,@PathVariable long id) throws Exception{
		return bService.update(bat, id);
}
  @DeleteMapping("/bat/{id}")
  public Batiment supprimer(@PathVariable long id) throws Exception{
	 return bService.delete(id); 
  }
  @GetMapping("/bats")
  public List<Batiment> getAllBat(){
	 return bService.findAll(); 
  }
  @GetMapping("/bat/{id}")
  public Batiment getById(@PathVariable long id )throws Exception {
	return bService.getById(id);  
  }
}
