package com.coforge.hms.dto;
import java.time.LocalDate;


import com.coforge.hms.model.*;
public class PaiementDTO {
 private long paiementId;
 private long montant;
 private Long id;
 private String name;
 private String prenom;
 private String Address;
 private String Sexe;
 private long Phone;
 private String Email;
 private String mois;
 private LocalDate datep;
 private TypeP typep;
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
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public PaiementDTO() {
	super();
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
public PaiementDTO(Paiement p) {
	super();
	this.typep=p.getTypep();
	this.paiementId=p.getPaiementId();
	this.montant=p.getMontant();
	this.mois=p.getMois();
	this.datep=p.getDatep();
	this.id=p.getId();
	this.name=p.getName();
	this.prenom=p.getPrenom();
	this.Sexe=p.getSexe();
	this.Address=p.getAddress();
	this.Phone=p.getPhone();
	this.Email=p.getEmail();
	
	
}
 
}
