package com.coforge.hms.service;
import com.coforge.hms.model.*;
import java.util.*;
public interface ClasseService {
  public Classe saveClasse(Classe c);
  public Classe getById(long classId)throws Exception;
  public List<Classe> listeClasse();
}
