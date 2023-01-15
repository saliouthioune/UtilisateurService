package com.coforge.hms.model;

import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;

@Entity
@Table(name="INSCRIRE")
public class Inscrire {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="insId")
	 private long insId;
	private String promo;
	@ManyToOne()
	 @JoinColumn(name="classId",referencedColumnName="classId")
	 private Classe classe;
	@ManyToOne()
	 @JoinColumn(name="id")
	 private Etudiant etudiant;
	public long getInsId() {
		return insId;
	}
	public void setInsId(long insId) {
		this.insId = insId;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	
	public String getPromo() {
		return promo;
	}
	public void setPromo(String promo) {
		this.promo = promo;
	}
	public Inscrire() {
		super();
	}
	
	
}
