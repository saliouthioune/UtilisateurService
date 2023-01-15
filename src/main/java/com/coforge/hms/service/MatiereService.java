package com.coforge.hms.service;
import com.coforge.hms.model.*;
import java.util.*;
public interface MatiereService {
public Matiere saveMat(Matiere mat);
public Matiere getById(Long idMat)throws Exception;
public List<Matiere> getAllMatiere();
}

