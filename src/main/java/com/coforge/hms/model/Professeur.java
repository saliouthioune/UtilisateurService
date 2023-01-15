package com.coforge.hms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "profId")
public class Professeur extends User{
 private String nom;
 private String prenom;
 @Column(name="EMAIL")
 private String email;
 private int age;
 private String sexe;
 private String address;
// @OneToOne()
// @JoinColumn(name="SAL_ID",referencedColumnName="SAL_ID")
//private Salaire salaire;
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getSexe() {
	return sexe;
}
public void setSexe(String sexe) {
	this.sexe = sexe;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Professeur() {
	super();
}

//public Salaire getSalaire() {
//	return salaire;
//}
//public void setSalaire(Salaire salaire) {
//	this.salaire = salaire;
//}
public Professeur(String username,String password,String nom, String prenom, String email, int age, String sexe, String address) {
	super(username,password);
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.age = age;
	this.sexe = sexe;
	this.address = address;
	

}

 
 
}
