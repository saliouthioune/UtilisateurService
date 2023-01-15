package com.coforge.hms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import javax.persistence.DiscriminatorValue;

@Entity
@PrimaryKeyJoinColumn(name = "directeurId")
public class Directeur extends User{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private String nom;
    private String prenom;

public Directeur() {
		super();
	}
public Directeur(String username,String password,String nom, String prenom) {
	super(username,password);
	this.nom = nom;
	this.prenom = prenom;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}

}
