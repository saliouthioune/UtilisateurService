package com.coforge.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.coforge.hms.model.Salle;
import com.coforge.hms.repository.SalleRepository;
@Service
@Transactional
public class SalleServiceImpl implements SalleService{
	@Autowired
 private SalleRepository sRepo;
	@Override
	public Salle save(Salle prof) {
		// TODO Auto-generated method stub
		return sRepo.save(prof);
	}

	@Override
	public List<Salle> findAll() {
		// TODO Auto-generated method stub
		return sRepo.findAll();
	}

	@Override
	public Salle update(Salle prof, long profId) throws Exception {
		// TODO Auto-generated method stub
		Salle s=getById(profId);
		s.setNom(prof.getNom());
		return s;
	}

	@Override
	public Salle delete(long salId) throws Exception {
		// TODO Auto-generated method stub
		Salle s=getById(salId);
		sRepo.delete(s);
		return s;
	}

	@Override
	public Salle getById(long salId) throws Exception {
		// TODO Auto-generated method stub
		Salle s=sRepo.findById(salId).orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " +salId));
		return s;
	}

	@Override
	public boolean existsByEmail(Salle sal) {
		// TODO Auto-generated method stub
		return false;
	}

}
