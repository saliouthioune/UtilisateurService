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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.hms.model.Classe;
import com.coforge.hms.repository.ClasseRepository;
import com.coforge.hms.service.ClasseServiceImpl;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
public class ClasseController {
	@Autowired
	private ClasseServiceImpl cService;
	@PostMapping(value="/class")
  public Classe saveClasse(@RequestBody Classe c) {
	  return cService.saveClasse(c);
  }
	
  @GetMapping("/class")
  public List<Classe> getAll(){
	  return cService.listeClasse();
  }
  @GetMapping("/classe/{classId}")
  public Classe getById(@PathVariable long classId) throws Exception{
	 return cService.getById(classId); 
  }
  @GetMapping("/classe")
  public Classe getCById(@RequestParam("classId") long classId) throws Exception{
	 return cService.getById(classId); 
  }
}
