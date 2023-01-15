package com.coforge.hms.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coforge.hms.model.Caissiere;
import com.coforge.hms.model.ERole;
import com.coforge.hms.model.Professeur;
import com.coforge.hms.model.Role;
import com.coforge.hms.repository.RoleRepository;
import com.coforge.hms.service.CaissiereService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value="/api")
public class CaissiereController {
	@Autowired
    private CaissiereService cService;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	RoleRepository roleRepository;
	@PostMapping("/caissiere")
	public Caissiere save(@RequestBody Caissiere prof) {
		Caissiere c=new Caissiere(prof.getUsername(),prof.getPassword(),prof.getName(),prof.getPrenom()
				,prof.getAddress(),prof.getSexe(),prof.getPhone(),prof.getEmail(),prof.getDatenaissance());
		c.setPassword(encoder.encode(prof.getPassword()));
		Role userRole = roleRepository.findByName(ERole.ROLE_CAISSIERE)
                .orElseThrow(() -> new RuntimeException("User Role not set."));
	c.setRoles(Collections.singleton(userRole));
		
		return cService.save(c);
	}
	@GetMapping(value="/caissiers")
	public List<Caissiere> getAll() {
		return cService.getAll();
	}
	@GetMapping(value="/caissiere/{profId}")
	public Caissiere getById(@PathVariable long profId) throws Exception{
		Caissiere c=cService.getById(profId);
		return c;
	}
	@DeleteMapping(value="/caissiere/{profId}")
	public Caissiere delete(@PathVariable long profId) throws Exception{
	 return cService.delete(profId);	
	}
	@PutMapping(value="/caissiere/{profId}")
	public Caissiere update(@RequestBody Caissiere prof,@PathVariable long profId) throws Exception{
		return cService.update(prof, profId);
	}
}
