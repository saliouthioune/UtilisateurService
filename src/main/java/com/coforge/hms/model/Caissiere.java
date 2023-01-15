package com.coforge.hms.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Caissiere extends User{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "NAME")
	private String name;
	@Column(name = "PRENOM")
	private String prenom;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "SEXE")
	private String sexe;
	@Column(name = "PHONE")
	private long Phone;
	@Column(name = "EMAIL")
	private String email;
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="datenaissance")
	private LocalDate datenaissance;
	
	public Caissiere() {
		super();
	}
	public Caissiere(String username, String password,String name, String prenom, String address, String sexe, long phone, String email,
			LocalDate datenaissance) {
		super(username,password);
		this.name = name;
		this.prenom = prenom;
		this.address = address;
		this.sexe = sexe;
		Phone = phone;
		this.email = email;
		this.datenaissance = datenaissance;
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
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public long getPhone() {
		return Phone;
	}
	public void setPhone(long phone) {
		Phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDatenaissance() {
		return datenaissance;
	}
	public void setDatenaissance(LocalDate datenaissance) {
		this.datenaissance = datenaissance;
	}
	
}
