package com.coforge.hms.dto;

import com.coforge.hms.model.*;

import java.time.LocalDate;
import java.util.Date;



public class EtudiantDTO {
	private long id;
	private String Name;
	
	private String Prenom;
	
	private String Address;
	
	private String Sexe;
	
	private long Phone;
	
	private String Email;
	private String username;
	private String password;
     private LocalDate datenaissance;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
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

	public LocalDate getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(LocalDate dateNaissance) {
		this.datenaissance = dateNaissance;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EtudiantDTO(Etudiant etudiant) {
		super();
		
		this.Name = etudiant.getName();
		this.Prenom = etudiant.getPrenom();
		this.Email = etudiant.getEmail();
		this.Sexe = etudiant.getSexe();
		this.Address = etudiant.getAddress();
		this.datenaissance=etudiant.getDatenaissance();
		this.Phone = etudiant.getPhone();
		this.username=etudiant.getUsername();
		this.password=etudiant.getPassword();
	}

	public EtudiantDTO() {
		super();
	}
	
	
}
