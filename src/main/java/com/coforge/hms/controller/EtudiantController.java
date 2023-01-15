package com.coforge.hms.controller;


import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.client.RestTemplate;

import com.coforge.hms.dto.EtudiantDTO;
import com.coforge.hms.dto.MailDTO;
import com.coforge.hms.model.*;
import com.coforge.hms.repository.EtudiantRepository;
import com.coforge.hms.repository.RoleRepository;
import com.coforge.hms.service.EmailService;
import com.coforge.hms.service.EtudiantServiceImpl;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value="/api")
public class EtudiantController {
	@Autowired
    private EtudiantRepository eRepo;
	@Autowired
	private EmailService emailService;
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	PasswordEncoder encoder;
	@Autowired
	RoleRepository roleRepository;
//	@Autowired
//	private RestTemplate restTemplate;
	//pour recuperer la liste des clients du service PaiementServices
	private String BASE_URI="http://localhost:8084/PaeimentServices/hms/api/etudiant";
	@GetMapping("/cours")
	public List<Etudiant>getAll(){
		RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Etudiant>> response = restTemplate.exchange(
                "http://localhost:8084/hms/api/etudiant",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Etudiant>>() {
                });
        List<Etudiant> users = response.getBody();
        for(Etudiant e:users)
        	eRepo.save(e);
        return users;
	}
	@GetMapping
	public void addaEtudiant() {
		RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<Etudiant>> response = restTemplate.exchange(
                "http://localhost:8084/hms/api/etudiant",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Etudiant>>() {
                });
        List<Etudiant> users = response.getBody();
        for(Etudiant e:users)
        	eRepo.save(e);
	}
	@Autowired
	private EtudiantServiceImpl docService;
	@PostMapping(value = "/etudiant", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public Etudiant addDoctor(@RequestBody Etudiant etudiant) {

		//EtudiantDTO etud = docService.save(etudiant);
		Etudiant doc =new Etudiant(etudiant.getUsername(),etudiant.getPassword(),etudiant.getName(),etudiant.getPrenom(),etudiant.getAddress(),etudiant.getSexe(),etudiant.getPhone(),
				etudiant.getEmail(),etudiant.getDatenaissance());
		doc.setPassword(encoder.encode(etudiant.getPassword()));
		Role userRole = roleRepository.findByName(ERole.ROLE_ETUDIANT)
                .orElseThrow(() -> new RuntimeException("User Role not set."));
		doc.setRoles(Collections.singleton(userRole));
		return docService.save(doc);
	}
	@PutMapping(value="/etudiant/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Etudiant> updateDoctor(@RequestBody Etudiant doctor,@PathVariable long id)
			throws Exception {

		Etudiant doc = docService.update(doctor,id);
		return ResponseEntity.ok().body(doc);
	}
	@DeleteMapping(value = "/etudiant/{id}")
	public Map<String, Boolean> deleteDoctor(@PathVariable long id) throws Exception {
		return docService.delete(id);
	}
	@GetMapping(value="/etudiant/{etudiantId}")
	public Etudiant getEtudiantById(@PathVariable long etudiantId) throws Exception {
		Etudiant doc = docService.getById(etudiantId);
		return doc;
	}
	//Deuxieme methode pour la recherche
	@GetMapping(value="/etudian/{etudiantId}")
	public Etudiant getEtudianById(@RequestParam long etudiantId) throws Exception {
		Etudiant doc = docService.getById(etudiantId);
		return doc;
	}
	@GetMapping(value = "/etudiant")
	public List<Etudiant> listAll() {
		
		
		return docService.getAll();
	}
	@PostMapping(value = "/etudiant/check")
	public ResponseEntity<Map<String, Boolean>> existsByEmail(@RequestBody EtudiantDTO doc){
		Map<String, Boolean> res = new HashMap<>();
		boolean present = docService.existsByNumber(doc);
		if(present) {
			res.put("available", Boolean.TRUE);
		}else {
			res.put("available", Boolean.FALSE);
		}
		return ResponseEntity.ok().body(res);
	}
	@PostMapping(value = "/email")
	public void sendEmail(@RequestBody MailDTO email) throws Exception {
        SimpleMailMessage mail = new SimpleMailMessage();
        Etudiant e=docService.getById(email.getId());
        mail.setFrom("thiounesaliou972@gmail.com");
        mail.setTo(e.getEmail());
        mail.setSubject(email.getEmailSubject());
        mail.setText(email.getEmailContent());

        javaMailSender.send(mail);
    }
}
