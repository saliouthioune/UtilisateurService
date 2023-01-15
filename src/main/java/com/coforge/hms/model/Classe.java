package com.coforge.hms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ClASSE")
public class Classe {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="classId")
    private long classId;
    private String nom;
	public Classe() {
		super();
	}
	
	public Classe(long classId, String nom) {
		super();
		this.classId = classId;
		this.nom = nom;
	
	}

	public long getClassId() {
		return classId;
	}
	public void setClassId(long classId) {
		this.classId = classId;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
    
}
