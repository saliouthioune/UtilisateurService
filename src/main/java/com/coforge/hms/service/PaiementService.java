package com.coforge.hms.service;

import java.util.List;
import java.util.Map;


import com.coforge.hms.dto.PaiementDTO;
import com.coforge.hms.model.Paiement;

public interface PaiementService {
	public Paiement save(Paiement  paiement);
	public PaiementDTO saveOM(PaiementDTO  paiement);
	
    public PaiementDTO  update(PaiementDTO  paiement, long paiementId) throws Exception;
	public PaiementDTO  getById(long doctorId) throws Exception;
	public List<PaiementDTO > getAll();
	public Map<String, Boolean> delete(long paiementId) throws Exception;
	public Paiement getCById(long compteId) throws Exception;
	public long montantTotalPaiement();
	
}
