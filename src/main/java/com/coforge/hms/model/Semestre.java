package com.coforge.hms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SEMESTRE")
public class Semestre {
	@Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 @Column(name="semId")
 private Long semId;
 private String nom;
public Long getSemId() {
	return semId;
}
public void setSemId(Long semId) {
	this.semId = semId;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public Semestre(Long semId, String nom) {
	super();
	this.semId = semId;
	this.nom = nom;
}
public Semestre() {
	super();
}
 
}
