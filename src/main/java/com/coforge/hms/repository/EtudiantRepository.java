package com.coforge.hms.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.hms.dto.EtudiantDTO;
import com.coforge.hms.model.*;
@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long>{
	public EtudiantDTO findByEmail(String email);
}
