package com.coforge.hms.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.hms.model.Directeur;
import com.coforge.hms.model.ERole;
import com.coforge.hms.model.Role;
import com.coforge.hms.repository.DirecteurRepository;
import com.coforge.hms.repository.RoleRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
public class DirecteurControlleur {
	@Autowired
	PasswordEncoder encoder;
	@Autowired
   private DirecteurRepository dRepo;
	@Autowired
	RoleRepository roleRepository;
	@GetMapping("/directeurs")
	public List<Directeur> getAll(){
		return dRepo.findAll();
	}
	@PostMapping("/addd")
	public Directeur addDirecteur(@RequestBody Directeur d){
		Directeur direc=new Directeur(d.getUsername(),encoder.encode(d.getPassword()),d.getNom(),d.getPrenom());
		Role userRole = roleRepository.findByName(ERole.ROLE_DIRECTEUR)
                .orElseThrow(() -> new RuntimeException("User Role not set."));
		direc.setRoles(Collections.singleton(userRole));
		return dRepo.save(direc);
	}
}
