package com.coforge.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.hms.model.Matiere;
import com.coforge.hms.repository.*;
@Service
@Transactional
public class MatiereServiceImpl implements MatiereService{
	@Autowired
    private MatiereRepository mRepo;
	@Override
	public Matiere saveMat(Matiere mat) {
		// TODO Auto-generated method stub
		return mRepo.save(mat);
	}

	@Override
	public Matiere getById(Long idMat) throws Exception {
		// TODO Auto-generated method stub
		Matiere m=mRepo.findById(idMat).orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + idMat));
		return m;
	}

	@Override
	public List<Matiere> getAllMatiere() {
		// TODO Auto-generated method stub
		return mRepo.findAll();
	}

}
