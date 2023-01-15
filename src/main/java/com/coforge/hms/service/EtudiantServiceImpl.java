package com.coforge.hms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coforge.hms.dto.EtudiantDTO;
import com.coforge.hms.model.Etudiant;
import com.coforge.hms.repository.EtudiantRepository;

@Service
@Transactional
public class EtudiantServiceImpl implements EtudiantService{
	@Autowired
	private EtudiantRepository eRepo;
    
private Etudiant convertDTOtoModel(EtudiantDTO doctorDTO) {
		
		Etudiant etudiant = new Etudiant();
		
		//etudiant.setEtudiantId(doctorDTO.getEtudiantId());
		etudiant.setName(doctorDTO.getName());
		etudiant.setPrenom(doctorDTO.getPrenom());
		etudiant.setEmail(doctorDTO.getEmail());
		etudiant.setAddress(doctorDTO.getAddress());
		etudiant.setDatenaissance(doctorDTO.getDatenaissance());
		etudiant.setSexe(doctorDTO.getSexe());
		etudiant.setPhone(doctorDTO.getPhone());
		
		return etudiant;
	}
/*
 * Convert Model To DTO
 */
private EtudiantDTO convertModelToDTO(Etudiant doc) {
	return new EtudiantDTO(doc);
}
	@Override
	public Etudiant save(Etudiant etudiant) {
		// TODO Auto-generated method stub
		
		
		return eRepo.save(etudiant);
}
	
	@Override
	public Etudiant update(Etudiant etudiant, long docId) throws Exception {
		// TODO Auto-generated method stub
Etudiant cpyDoctor = getById(docId);
        cpyDoctor.setUsername(etudiant.getUsername());
        cpyDoctor.setPassword(etudiant.getPassword());
		cpyDoctor.setName(etudiant.getName());
		cpyDoctor.setPrenom(etudiant.getPrenom());
		cpyDoctor.setAddress(etudiant.getAddress());
		cpyDoctor.setDatenaissance(etudiant.getDatenaissance());
		cpyDoctor.setEmail(etudiant.getEmail());
		cpyDoctor.setSexe(etudiant.getSexe());
		cpyDoctor.setPhone(etudiant.getPhone());
		return cpyDoctor;
	}

	@Override
	public Etudiant getById(long doctorId) throws Exception {
		// TODO Auto-generated method stub
		Etudiant doctor = eRepo.findById(doctorId).orElseThrow(() -> new Exception("ID Etudiant NOT FOUND EXCEPTION ::::"+doctorId));
		return doctor;
	}

	@Override
	public List<Etudiant> getAll() {
		// TODO Auto-generated method stub
		
		return eRepo.findAll();
		
	}

	@Override
	public Map<String, Boolean> delete(long doctorId) throws Exception {
		// TODO Auto-generated method stub
		Etudiant doc = eRepo.findById(doctorId).orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION ::::"+doctorId));
		
		eRepo.delete(doc);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Delete", Boolean.TRUE);
		
		return response;
	}

	@Override
	public boolean existsByNumber(EtudiantDTO docDto) {
		// TODO Auto-generated method stub
		EtudiantDTO doc = eRepo.findByEmail(docDto.getEmail());
		if(doc != null) {
			return true;
		}
		else {
			return false;
		}
	}

	
}
