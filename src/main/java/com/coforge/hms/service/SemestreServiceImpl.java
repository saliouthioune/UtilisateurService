package com.coforge.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.hms.model.Salle;
import com.coforge.hms.model.Semestre;
import com.coforge.hms.repository.*;
@Service
@Transactional
public class SemestreServiceImpl implements SemestreService{
	@Autowired
   private SemestreRepository sRepo;
	@Override
	public Semestre save(Semestre s) {
		// TODO Auto-generated method stub
		return sRepo.save(s);
	}

	@Override
	public Semestre getById(Long semId) throws Exception {
		// TODO Auto-generated method stub
		Semestre s=sRepo.findById(semId).orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " +semId));
		return s;
	}

	@Override
	public List<Semestre> getAll() {
		// TODO Auto-generated method stub
		return sRepo.findAll();
	}
 
}
