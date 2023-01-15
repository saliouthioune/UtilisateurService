package com.coforge.hms.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.coforge.hms.dto.EtudiantDTO;
import com.coforge.hms.model.Inscrire;
import com.coforge.hms.repository.InscrireRepository;


@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
public class InscrireController {
	@Autowired
	private InscrireRepository iRepo;
	@PostMapping(value="/inscription")
    public Inscrire add(@RequestBody Inscrire i) {
	return iRepo.save(i);
   }
	@GetMapping(value="/inscriptions")
	public List<Inscrire> getAll(){
		return iRepo.findAll();
	}
	//Get Inscription by id
	@GetMapping("/inscription/{insId}")
	public Optional<Inscrire> getById(@PathVariable long insId) {
		return iRepo.findById(insId);
	}
	
	
}
