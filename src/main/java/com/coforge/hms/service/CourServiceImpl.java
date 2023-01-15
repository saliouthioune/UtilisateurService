package com.coforge.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.hms.model.Cour;
import com.coforge.hms.repository.*;
@Service
@Transactional
public class CourServiceImpl implements CourService{
	@Autowired
    private CourRepository cRepo;
	@Override
	public Cour addCour(Cour c) {
		// TODO Auto-generated method stub
		return cRepo.save(c);
	}

	@Override
	public List<Cour> listeCour() {
		// TODO Auto-generated method stub
		return cRepo.findAll();
	}

}
