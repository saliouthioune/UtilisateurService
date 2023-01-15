package com.coforge.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.hms.model.Classe;
import com.coforge.hms.repository.ClasseRepository;
@Service
@Transactional
public class ClasseServiceImpl implements ClasseService{
	@Autowired
     private ClasseRepository cRepo;
	@Override
	public Classe saveClasse(Classe c) {
		// TODO Auto-generated method stub
		return cRepo.save(c);
	}
	@Override
	public Classe getById(long classId) throws Exception {
		// TODO Auto-generated method stub
		Classe c=cRepo.findById(classId).orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + classId));
		return c;
	}
	@Override
	public List<Classe> listeClasse() {
		// TODO Auto-generated method stub
		return cRepo.findAll();
	}

}
