package com.coforge.hms.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.coforge.hms.model.Professeur;

public interface ProfesseurRepository extends JpaRepository<Professeur,Long>{
	public Professeur findByEmail(String email);
}
