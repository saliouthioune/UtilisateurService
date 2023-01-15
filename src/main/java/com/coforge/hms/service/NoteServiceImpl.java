package com.coforge.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.coforge.hms.repository.*;
import com.coforge.hms.model.*;
import java.util.*;
@Service
@Transactional
public class NoteServiceImpl {
	
 @Autowired	
 private NoteRepository nRepo;
 
 public Note save(Note n) {
	 return nRepo.save(n);
 }
 public List<Note>getAll(){
	 return nRepo.findAll();
 }
}
