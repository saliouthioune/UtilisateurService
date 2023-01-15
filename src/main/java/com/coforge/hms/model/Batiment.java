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
@Table(name="BATIMENT")
public class Batiment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BATIMENT_ID")
    private long batimentId;
	private String nom;
	@ManyToOne()
	@JoinColumn(name="salleId",referencedColumnName="salleId")
	private Salle salle;
	public long getBatimentId() {
		return batimentId;
	}
	public void setBatimentId(long batimentId) {
		this.batimentId = batimentId;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	
	
	public Batiment(long batimentId, String nom, Salle salle) {
		super();
		this.batimentId = batimentId;
		this.nom = nom;
		this.salle = salle;
	}
	public Batiment() {
		super();
	}
	
}
