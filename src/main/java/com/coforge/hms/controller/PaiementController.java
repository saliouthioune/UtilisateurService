package com.coforge.hms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.coforge.hms.dto.EtudiantDTO;

import com.coforge.hms.dto.MailDTO;
import com.coforge.hms.dto.PaiementDTO;
import com.coforge.hms.model.Etudiant;
import com.coforge.hms.model.Paiement;
import com.coforge.hms.service.EmailService;
import com.coforge.hms.service.PaiementServiceImpl;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
public class PaiementController {
	@Autowired	
	private PaiementServiceImpl pService;
	
	@Autowired
	private EmailService emailService;
	
	//cette methode accomplit le service de paiement par mode cache.
	@PostMapping(value="paiement")
	public Paiement newpaiement(@RequestBody Paiement p) {
		
		return pService.save(p); 
	}
	//c'est la methode de paiement par voix electronique particulierement orange money
	@PostMapping(value="paiementom")
	public PaiementDTO newpaiementOM(@RequestBody PaiementDTO p) {
		
		return pService.saveOM(p); 
	}
	@GetMapping(value="paiement")
	public List<PaiementDTO>getAll(){
		return pService.getAll();
	}
	@GetMapping("/paiement/{paiementId}")
	public PaiementDTO getById(@PathVariable long paiementId) throws Exception {
		return pService.getById(paiementId);
	}
	//Recuperer un etudiant du service Cours Service par son id
	@GetMapping("/pp/{id}")
	public EtudiantDTO getByIdp(@PathVariable long id) {
		RestTemplate restTemplate=new RestTemplate();
		return restTemplate.getForObject("http://localhost:8083/hms/api/etudiant/"+id, EtudiantDTO.class); 
	 }
	//Recuperer la liste des eleves du cour service 
//	@GetMapping("/pps")
//	public ResponseEntity<InscrireDTO[]> getAllEtudiant() {
//		RestTemplate restTemplate=new RestTemplate(); 
//		return restTemplate.getForEntity("http://localhost:8084/hms/api/inscriptions",InscrireDTO[].class);
//	 }
//	@PostMapping(value = "/paiement/check")
//	public ResponseEntity<Map<String, Boolean>> existsByEmail(@RequestBody PaiementDTO doc){
//		Map<String, Boolean> res = new HashMap<>();
//		boolean present = pService.existsByNumber(doc);
//		if(present) {
//			res.put("available", Boolean.TRUE);
//		}else {
//			res.put("available", Boolean.FALSE);
//		}
//		return ResponseEntity.ok().body(res);
//	}
	@GetMapping("/paiement/montantTotal")
	public long montantTotalPaiement() {
		return pService.montantTotalPaiement();
	}
	
	
	

	 //some other code

//	  @PostMapping(value = "/email")
//	  public ResponseEntity<MailDTO> enviarEmail(@RequestBody MailDTO email){
//	    try {
//	      emailService.sendEmail(email);
//	      return new ResponseEntity<>(email,  HttpStatus.OK);
//	    } catch( MailException e){
//	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//	    }
//
//
//	  }

}

