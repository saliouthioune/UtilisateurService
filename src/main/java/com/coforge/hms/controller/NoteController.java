package com.coforge.hms.controller;

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

import com.coforge.hms.repository.NoteRepository;
import com.coforge.hms.service.*;
import com.coforge.hms.model.*;
import java.util.*;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping(value="/api")
public class NoteController {
 @Autowired	
 private NoteServiceImpl nService;
 @Autowired	
 private NoteRepository nRepo;
 
 
 @PostMapping(value="/addnote")
 public Note nouvelleInscription(@RequestBody Note i) throws Exception{
 	
 	return nService.save(i);
 }
 @GetMapping(value="/notes")
 public List<Note> getAll(){
	return nService.getAll(); 
 }
	//Convertir un model en dto
// @GetMapping("/elevesnotes")
//	public ResponseEntity<InscrireDTO[]> getAllEtudiant() {
//		RestTemplate restTemplate=new RestTemplate(); 
//		return restTemplate.getForEntity("http://localhost:8084/hms/api/inscriptions",InscrireDTO[].class);
//	 }
	@GetMapping(value="/notes/{id}/{classId}/{semId}")
	public List<Note> noteEtudiantClasse(@PathVariable long id,@PathVariable long classId,@PathVariable long semId){
		return nRepo.noteEtudiantClasse(id, classId,semId);
	}
	@GetMapping(value="/somme/{id}/{classId}/{semId}")
	public long somme(@PathVariable long id,@PathVariable long classId,@PathVariable long semId) {
		return nRepo.somme(id, classId,semId);
	}
	@GetMapping(value="/sommenc/{id}/{classId}/{semId}")
	public long sommenc(@PathVariable long id,@PathVariable long classId,@PathVariable long semId) {
		return nRepo.sommenc(id, classId,semId);
	}
	@GetMapping(value="/sommec/{id}/{classId}/{semId}")
	public long sommec(@PathVariable long id,@PathVariable long classId,@PathVariable long semId) {
		return nRepo.sommec(id, classId,semId);
	}
	
	@GetMapping(value="/nbmatiere/{id}/{classId}/{semId}")
	public long nbmatiere(@PathVariable long id,@PathVariable long classId,@PathVariable long semId) {
		return nRepo.nbmatiere(id, classId,semId);
	}
}
