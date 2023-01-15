package com.coforge.hms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.coforge.hms.service.*;
import com.coforge.hms.model.*;
import com.coforge.hms.repository.CourRepository;
import com.coforge.hms.service.*;
import java.util.*;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value="/api")
public class CourController {
@Autowired	
private CourServiceImpl cService;

@Autowired	
private CourRepository iRepo;
@PostMapping(value="/addcour")
public Cour nouvelleInscription(@RequestBody Cour i) throws Exception{
	return cService.addCour(i);
}
@GetMapping(value="/listecours")
public List<Cour> listeCour(){
	return cService.listeCour();
}
	//Convertir un model en dto
	
}
