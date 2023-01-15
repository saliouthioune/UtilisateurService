package com.coforge.hms.service;

import java.util.List;

import com.coforge.hms.model.Salle;

public interface SalleService {
	public Salle save(Salle prof);
	   public List<Salle>findAll();
	   public Salle update(Salle prof,long profId)throws Exception; 
	   public Salle delete(long salId)throws Exception;
	   public Salle getById(long salId) throws Exception;
	   public boolean existsByEmail(Salle sal);
	
}
