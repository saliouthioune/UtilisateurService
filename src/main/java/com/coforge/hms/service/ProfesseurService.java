package com.coforge.hms.service;

import java.util.List;
import java.util.Map;


import com.coforge.hms.model.Professeur;


public interface ProfesseurService {
   public Professeur save(Professeur prof);
   public List<Professeur>findAll();
   public Professeur update(Professeur prof,long profId)throws Exception; 
   public Professeur delete(long profId)throws Exception;
   public Professeur getById(long profId) throws Exception;
   public boolean existsByEmail(Professeur doc);
}
