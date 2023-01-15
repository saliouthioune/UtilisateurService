package com.coforge.hms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.coforge.hms.model.Semestre;
import com.coforge.hms.service.*;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping(value = "/api")
public class SemestreController {
  @Autowired
  private SemestreServiceImpl sService;
  @PostMapping(value="/semestre")
  public Semestre save(@RequestBody Semestre s) {
	  return sService.save(s);
  }
  @GetMapping(value="/semestre/{semId}")
  public Semestre getById(@PathVariable Long semId) throws Exception{
	  return sService.getById(semId);
  }
  @GetMapping(value="/semestres")
  public List<Semestre>getAll(){
	  return sService.getAll();
  }
}
