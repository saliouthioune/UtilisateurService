package com.coforge.hms.service;
import com.coforge.hms.model.*;
import java.util.*;
public interface SemestreService {
public Semestre save(Semestre s);
public Semestre getById(Long semId)throws Exception;
public List<Semestre> getAll();
}
