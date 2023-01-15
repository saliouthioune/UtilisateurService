package com.coforge.hms.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.hms.model.ERole;
import com.coforge.hms.model.Professeur;
import com.coforge.hms.model.Role;
import com.coforge.hms.repository.RoleRepository;
import com.coforge.hms.service.ProfesseurServiceImpl;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value="/api")
public class ProfesseurController {
	@Autowired
    private ProfesseurServiceImpl pService;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	RoleRepository roleRepository;
	
	
	@PostMapping("/prof")
	public Professeur save(@RequestBody Professeur prof) {
		Professeur p=new Professeur(prof.getUsername(),prof.getPassword(),prof.getNom(),prof.getPrenom(),prof.getEmail(),prof.getAge()
				,prof.getSexe(),prof.getAddress());
		p.setPassword(encoder.encode(prof.getPassword()));
		Role userRole = roleRepository.findByName(ERole.ROLE_ENSEIGNANT)
                .orElseThrow(() -> new RuntimeException("User Role not set."));
	p.setRoles(Collections.singleton(userRole));
		
		return pService.save(p);
	}
	@GetMapping(value="/prof")
	public List<Professeur> getAll() {
		return pService.findAll();
	}
	@DeleteMapping(value="/prof/{profId}")
	public Professeur delete(@PathVariable long profId) throws Exception{
	 return pService.delete(profId);	
	}
	@GetMapping(value="/prof/{profId}")
	public Professeur getById(@PathVariable long profId) throws Exception{
		Professeur p=pService.getById(profId);
		return p;
	}
	@PutMapping(value="/prof/{profId}")
	public Professeur update(@RequestBody Professeur prof,@PathVariable long profId) throws Exception{
		return pService.update(prof, profId);
	}
	@PostMapping(value = "/prof/check")
	public ResponseEntity<Map<String, Boolean>> existsByEmail(@RequestBody Professeur prof){
		Map<String, Boolean> res = new HashMap<>();
		boolean present = pService.existsByEmail(prof);
		if(present) {
			res.put("available", Boolean.TRUE);
		}else {
			res.put("available", Boolean.FALSE);
		}
		return ResponseEntity.ok().body(res);
	}
	//get prof by id for inserted in Cour table
	@GetMapping(value="/professeur")
	public Professeur getCById(@RequestParam("profId") long profId) throws Exception{
		Professeur p=pService.getById(profId);
		return p;
	}
}
