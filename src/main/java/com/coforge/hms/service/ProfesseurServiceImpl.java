package com.coforge.hms.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.coforge.hms.model.Professeur;
import com.coforge.hms.repository.ProfesseurRepository;

@Service
@Transactional
public class ProfesseurServiceImpl implements ProfesseurService{
	
	@Autowired
    private ProfesseurRepository pRepo;
	
	
	@Override
	public Professeur save(Professeur prof) {
		// TODO Auto-generated method stub
		return pRepo.save(prof);
	}

	@Override
	public List<Professeur> findAll() {
		// TODO Auto-generated method stub
		return pRepo.findAll();
	}

	@Override
	public Professeur update(Professeur prof, long profId) throws Exception {
		// TODO Auto-generated method stub
		Professeur p=getById(profId);
		p.setNom(prof.getNom());
		p.setPrenom(prof.getPrenom());
		p.setAddress(prof.getAddress());
		p.setEmail(prof.getEmail());
		p.setSexe(prof.getSexe());
		return p;
	}

	@Override
	public Professeur delete(long profId) throws Exception {
		// TODO Auto-generated method stub
		Professeur p=getById(profId);
		pRepo.delete(p);
		return p;
	}

	@Override
	public Professeur getById(long profId) throws Exception {
		// TODO Auto-generated method stub
		Professeur p=pRepo.findById(profId).orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + profId));
		return p;
	}

	@Override
	public boolean existsByEmail(Professeur proff) {
		// TODO Auto-generated method stub
		Professeur prof = pRepo.findByEmail(proff.getEmail());
		if(prof != null) {
			return true;
		}
		else {
			return false;
		}
	}

}
