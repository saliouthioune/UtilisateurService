package com.coforge.hms.service;

import java.util.List;
import java.util.Map;

import com.coforge.hms.dto.EtudiantDTO;
import com.coforge.hms.model.Caissiere;

public interface CaissiereService {
	public Caissiere save(Caissiere c);
    public Caissiere update(Caissiere c, long docId) throws Exception;
	public Caissiere getById(long doctorId) throws Exception;
	public List<Caissiere> getAll();
	public Caissiere delete(long doctorId) throws Exception;
	public boolean existsByNumber(EtudiantDTO doc);
}
