package com.coforge.hms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.coforge.hms.dto.PaiementDTO;

import com.coforge.hms.model.Paiement;
import com.coforge.hms.model.TypeP;
import com.coforge.hms.repository.PaiementRepository;

@Service
@Transactional
public class PaiementServiceImpl implements PaiementService{
     @Autowired
     private PaiementRepository pRepo;
     //@Autowired
     //private OperationPRepository oRepo;
 private Paiement convertDTOtoModel(PaiementDTO paiementDTO) {
 		Paiement paiement = new Paiement();
 		paiement.setPaiementId(paiementDTO.getPaiementId());
 		paiement.setMontant(paiementDTO.getMontant());
 		paiement.setMois(paiementDTO.getMois());
 		paiement.setDatep(paiementDTO.getDatep());
 		paiement.setId(paiementDTO.getId());
 		paiement.setName(paiementDTO.getName());
		paiement.setPrenom(paiementDTO.getPrenom());
		paiement.setAddress(paiementDTO.getAddress());
		paiement.setEmail(paiementDTO.getEmail());
		paiement.setPhone(paiementDTO.getPhone());
		paiement.setSexe(paiementDTO.getSexe());
 		paiement.setTypep(TypeP.p_CHEC);
 		return paiement;
 }
 private Paiement convertDTOtoModelOM(PaiementDTO paiementDTO) {
		Paiement paiement = new Paiement();
		paiement.setPaiementId(paiementDTO.getPaiementId());
		paiement.setMontant(paiementDTO.getMontant());
		paiement.setMois(paiementDTO.getMois());
		paiement.setDatep(paiementDTO.getDatep());
		paiement.setId(paiementDTO.getId());
		paiement.setName(paiementDTO.getName());
		paiement.setPrenom(paiementDTO.getPrenom());
		paiement.setAddress(paiementDTO.getAddress());
		paiement.setEmail(paiementDTO.getEmail());
		paiement.setPhone(paiementDTO.getPhone());
		paiement.setSexe(paiementDTO.getSexe());
		paiement.setTypep(TypeP.P_CASH);
		return paiement;
}

 private PaiementDTO convertModelToDTO(Paiement paiement) {
		return new PaiementDTO(paiement);
}    
	@Override
	public Paiement save(Paiement paiement) {
		// TODO Auto-generated method stub
		paiement.setTypep(TypeP.P_CASH);
		return pRepo.save(paiement);
		
	}

	@Override
	public PaiementDTO update(PaiementDTO paiement, long paiementId) throws Exception {
		// TODO Auto-generated method stub
		PaiementDTO cpyPaie = getById(paiementId);
		cpyPaie.setMontant(paiement.getMontant());
		cpyPaie.setMois(paiement.getMois());
		cpyPaie.setDatep(paiement.getDatep());
		cpyPaie.setId(paiement.getId());
		paiement.setName(paiement.getName());
		paiement.setPrenom(paiement.getPrenom());
		paiement.setAddress(paiement.getAddress());
		paiement.setEmail(paiement.getEmail());
		paiement.setPhone(paiement.getPhone());
		paiement.setSexe(paiement.getSexe());
		Paiement spec = convertDTOtoModel(cpyPaie);
		
		pRepo.save(spec);
		return convertModelToDTO(spec);
	}

	@Override
	public PaiementDTO getById(long paiementId) throws Exception {
		// TODO Auto-generated method stub
		Paiement paiement = pRepo.findById(paiementId)
				.orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION :::: " + paiementId));
		 return convertModelToDTO(paiement);
	}

	@Override
	public List<PaiementDTO> getAll() {
		// TODO Auto-generated method stub
		List<Paiement> paiementList = pRepo.findAll();
		List<PaiementDTO> paiementDTOList = new ArrayList<>();
		
		for(Paiement paiement : paiementList) {
			paiementDTOList.add(convertModelToDTO(paiement));
		}
		
		return paiementDTOList;
	}

	@Override
	public Map<String, Boolean> delete(long paiementId) throws Exception {
		// TODO Auto-generated method stub
		Paiement niveau = convertDTOtoModel(getById(paiementId));
		pRepo.delete(niveau);
		Map<String, Boolean> response = new HashMap<>();
		
		response.put("Delete", Boolean.TRUE);
		
		return response;
	}

//	@Override
//	public boolean existsByNumber(PaiementDTO doc) {
//		// TODO Auto-generated method stub
//		PaiementDTO p=pRepo.findByMoisAndEtudiant(doc.getMois(), doc.getEtudiantId());
//		if(p != null) {
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
	@Override
	public Paiement getCById(long compteId) throws Exception {
		// TODO Auto-generated method stub
		Paiement p=pRepo.findById(compteId).orElseThrow();
		//log.info(codeCpte);
		if(p==null)
			throw new RuntimeException("compte introuvable");	
    
	 return p;
	}
	@Override
	public long montantTotalPaiement() {
		// TODO Auto-generated method stub
		return pRepo.montantPaiement();
	}
	
	@Override
	public PaiementDTO saveOM(PaiementDTO paiement) {
		// TODO Auto-generated method stub
		Paiement paiementOM = convertDTOtoModelOM(paiement);
		pRepo.save(paiementOM);
		return convertModelToDTO(paiementOM); // return DTO
	}


}
