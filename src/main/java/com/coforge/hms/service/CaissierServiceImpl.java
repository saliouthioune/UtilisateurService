package com.coforge.hms.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coforge.hms.dto.EtudiantDTO;
import com.coforge.hms.model.Caissiere;
import com.coforge.hms.model.Etudiant;
import com.coforge.hms.model.Professeur;
import com.coforge.hms.repository.CaissiereRepository;

@Service
class CaissierServiceImpl implements CaissiereService{
    @Autowired
    private CaissiereRepository cRepo;
	@Override
	public Caissiere save(Caissiere c) {
		// TODO Auto-generated method stub
		return cRepo.save(c);
	}

	@Override
	public Caissiere update(Caissiere c, long docId) throws Exception {
		// TODO Auto-generated method stub
		Caissiere cc=getById(docId);
	    cc.setName(c.getName());
	    cc.setPrenom(c.getPrenom());
	    cc.setAddress(c.getAddress());
	    cc.setPhone(c.getPhone());
	    cc.setSexe(c.getSexe());
	    cc.setDatenaissance(c.getDatenaissance());
	    cc.setUsername(c.getUsername());
	    cc.setPassword(c.getPassword());
		return cc;
	}

	@Override
	public Caissiere getById(long doctorId) throws Exception {
		// TODO Auto-generated method stub
		Caissiere caissiee = cRepo.findById(doctorId).orElseThrow(() -> new Exception("ID Etudiant NOT FOUND EXCEPTION ::::"+doctorId));
		return caissiee;
	}

	@Override
	public List<Caissiere> getAll() {
		// TODO Auto-generated method stub
		return cRepo.findAll();
	}

	@Override
	public Caissiere delete(long doctorId) throws Exception {
		// TODO Auto-generated method stub
		Caissiere p=getById(doctorId);
		cRepo.delete(p);
		return p;
	}

	@Override
	public boolean existsByNumber(EtudiantDTO doc) {
		// TODO Auto-generated method stub
		return false;
	}

}
