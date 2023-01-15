package com.coforge.hms.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="PAIEMENT")
public class Paiement {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="PAIEMENT_ID")
  private long paiementId;
  @Column(name="MONTANT")
  private long montant;
  private String mois;
  @JsonFormat(pattern="yyyy-MM-dd")
  @Column(name="datep")
  private LocalDate datep;
  @ManyToOne()
  @JoinColumn(name="insId",referencedColumnName="insId")
  private Inscrire inscrire;
  private Long id;
  private String name;
  private String prenom;
  private String Address;
  private String Sexe;
  private long Phone;
  private String Email;
  @Enumerated(EnumType.STRING)
  private TypeP typep;
public Paiement() {
	super();
}
public long getPaiementId() {
	return paiementId;
}
public void setPaiementId(long paiementId) {
	this.paiementId = paiementId;
}
public long getMontant() {
	return montant;
}
public void setMontant(long montant) {
	this.montant = montant;
}



public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getMois() {
	return mois;
}
public void setMois(String mois) {
	this.mois = mois;
}
public LocalDate getDatep() {
	return datep;
}
public void setDatep(LocalDate datep) {
	this.datep = datep;
}
public TypeP getTypep() {
	return typep;
}
public void setTypep(TypeP typep) {
	this.typep = typep;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getSexe() {
	return Sexe;
}
public void setSexe(String sexe) {
	Sexe = sexe;
}
public long getPhone() {
	return Phone;
}
public void setPhone(long phone) {
	Phone = phone;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public Inscrire getInscrire() {
	return inscrire;
}
public void setInscrire(Inscrire inscrire) {
	this.inscrire = inscrire;
}

 
}
