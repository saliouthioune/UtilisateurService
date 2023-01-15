package com.coforge.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.hms.model.Batiment;
import com.coforge.hms.repository.BatimentRepository;
@Service
@Transactional
public class BatimentServiceImpl implements BatimentService{
	@Autowired
    private BatimentRepository bRepo; 
	@Override
	public Batiment save(Batiment bat) {
		// TODO Auto-generated method stub
		return bRepo.save(bat);
	}

	@Override
	public List<Batiment> findAll() {
		// TODO Auto-generated method stub
		return bRepo.findAll();
	}

	@Override
	public Batiment update(Batiment bat, long batId) throws Exception {
		// TODO Auto-generated method stub
		Batiment b=getById(batId);
		b.setNom(bat.getNom());
		b.setSalle(bat.getSalle());
		bRepo.save(bat);
		return b;
	}

	@Override
	public Batiment delete(long batId) throws Exception {
		// TODO Auto-generated method stub
		Batiment b=getById(batId);
		 bRepo.delete(b);
		 return b;
	}

	@Override
	public Batiment getById(long batId) throws Exception {
		// TODO Auto-generated method stub
		Batiment b=bRepo.findById(batId).orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " +batId));
		return b;
	}

}
