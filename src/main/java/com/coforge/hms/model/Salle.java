package com.coforge.hms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="SALLE")
public class Salle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="salleId")
    private long salleId;
    private String nom;
	public long getSalleId() {
		return salleId;
	}
	public void setSalleId(long salleId) {
		this.salleId = salleId;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Salle() {
		super();
	}
	public Salle(long salleId, String nom) {
		super();
		this.salleId = salleId;
		this.nom = nom;
	}
    
}
