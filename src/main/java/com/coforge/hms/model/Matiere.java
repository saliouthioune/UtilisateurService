package com.coforge.hms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MATIERE")
public class Matiere {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="matId")
    private Long matId;
	private int coef;
	private String nom;
	
	public Long getMatId() {
		return matId;
	}

	public void setMatId(Long matId) {
		this.matId = matId;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
    
	

	public int getCoef() {
		return coef;
	}

	public void setCoef(int coef) {
		this.coef = coef;
	}
     
	public Matiere(Long matId, int coef, String nom) {
		super();
		this.matId = matId;
		this.coef = coef;
		this.nom = nom;
	}

	public Matiere() {
		super();
	}
	
}
