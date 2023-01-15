package com.coforge.hms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="NOTE")
public class Note {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long noteId;
	@ManyToOne()
	@JoinColumn(name="insId",referencedColumnName="insId")
    private Inscrire inscrire;
	@ManyToOne()
	@JoinColumn(name="semId",referencedColumnName="semId")
    private Semestre semestre;
	@ManyToOne()
	@JoinColumn(name="matId",referencedColumnName="matId")
    private Matiere matiere;
    private int note;
    private int coef;
public int getNote() {
	return note;
}
public void setNote(int note) {
	this.note = note;
}
public long getNoteId() {
	return noteId;
}
public void setNoteId(long noteId) {
	this.noteId = noteId;
}
public int getCoef() {
	return coef;
}
public void setCoef(int coef) {
	this.coef = coef;
}
public Inscrire getInscrire() {
	return inscrire;
}
public void setInscrire(Inscrire inscrire) {
	this.inscrire = inscrire;
}
public Semestre getSemestre() {
	return semestre;
}
public void setSemestre(Semestre semestre) {
	this.semestre = semestre;
}
public Matiere getMatiere() {
	return matiere;
}
public void setMatiere(Matiere matiere) {
	this.matiere = matiere;
}
public Note() {
	super();
}
 
}
