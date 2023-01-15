package com.coforge.hms.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coforge.hms.dto.PaiementDTO;
import com.coforge.hms.model.Etudiant;
import com.coforge.hms.model.Paiement;
public interface PaiementRepository extends JpaRepository<Paiement,Long>{
  //public PaiementDTO findByMoisAndEtudiantId(String mois,Etudiant e);
  @Query("Select SUM(montant) from Paiement")
  public long montantPaiement();
}
