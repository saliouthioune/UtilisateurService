package com.coforge.hms.service;
import java.util.List;
import java.util.Map;

import com.coforge.hms.dto.*;
import com.coforge.hms.model.Etudiant;
public interface EtudiantService {
	public Etudiant save(Etudiant etudiant);
    public Etudiant update(Etudiant etudiant, long docId) throws Exception;
	public Etudiant getById(long doctorId) throws Exception;
	public List<Etudiant> getAll();
	public Map<String, Boolean> delete(long doctorId) throws Exception;
	public boolean existsByNumber(EtudiantDTO doc);
}
