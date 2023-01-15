package com.coforge.hms.service;

import java.util.List;

import com.coforge.hms.model.Batiment;


public interface BatimentService {
 public Batiment save(Batiment bat);
 public List<Batiment>findAll();
 public Batiment update(Batiment bat,long batId)throws Exception; 
 public Batiment delete(long batId)throws Exception;
 public Batiment getById(long batId) throws Exception;
 
 
}
