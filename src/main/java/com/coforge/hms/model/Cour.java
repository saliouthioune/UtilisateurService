package com.coforge.hms.model;

import java.time.LocalDate;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="COUR")
public class Cour {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long courId;
	 @ManyToOne()
	 @JoinColumn(name="matId",referencedColumnName="matId")
	 private Matiere matiere;
	 @ManyToOne()
	 @JoinColumn(name="semId",referencedColumnName="semId")
	 private Semestre semestre;
	 @ManyToOne()
	 @JoinColumn(name="salleId",referencedColumnName="salleId")
	 private Salle salle;
	 @ManyToOne()
	 @JoinColumn(name="id")
	 private Professeur prof;
	 @ManyToOne()
	 @JoinColumn(name="classId",referencedColumnName="classId")
	private Classe  classe;
  private String hdebut;
  private String hfin;
  @JsonFormat(pattern="yyyy-MM-dd")
  @Column(name="datenaissance")
  private LocalDate datec;


public String getHdebut() {
	return hdebut;
}
public void setHdebut(String hdebut) {
	this.hdebut = hdebut;
}
public String getHfin() {
	return hfin;
}
public void setHfin(String hfin) {
	this.hfin = hfin;
}

public LocalDate getDatec() {
	return datec;
}
public void setDatec(LocalDate datec) {
	this.datec = datec;
}

public long getCourId() {
	return courId;
}
public void setCourId(long courId) {
	this.courId = courId;
}
public Matiere getMatiere() {
	return matiere;
}
public void setMatiere(Matiere matiere) {
	this.matiere = matiere;
}
public Semestre getSemestre() {
	return semestre;
}
public void setSemestre(Semestre semestre) {
	this.semestre = semestre;
}
public Salle getSalle() {
	return salle;
}
public void setSalle(Salle salle) {
	this.salle = salle;
}
public Professeur getProf() {
	return prof;
}
public void setProf(Professeur prof) {
	this.prof = prof;
}
public Classe getClasse() {
	return classe;
}
public void setClasse(Classe classe) {
	this.classe = classe;
}
public Cour() {
	super();
}
  
}
