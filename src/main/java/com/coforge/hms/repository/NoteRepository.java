package com.coforge.hms.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coforge.hms.model.*;
@Repository
public interface NoteRepository extends JpaRepository<Note,Long>{
	@Query( "SELECT n FROM Note as n  WHERE n.inscrire.etudiant.id=?1 AND n.inscrire.classe.classId=?2 AND n.semestre.semId=?3")	
	public List<Note> noteEtudiantClasse(long id,long classId,long semId);
	
	@Query("SELECT SUM(note) FROM Note as n WHERE n.inscrire.etudiant.id=?1 AND n.inscrire.classe.classId=?2 AND n.semestre.semId=?3")
	public long somme(long id,long classId,long semId);
		
	@Query("SELECT Count(matId) FROM Note as n WHERE n.inscrire.etudiant.id=?1 AND n.inscrire.classe.classId=?2 AND n.semestre.semId=?3")
	public long nbmatiere(long id,long classId,long semId);
	@Query("SELECT SUM(note*coef) FROM Note as n WHERE n.inscrire.etudiant.id=?1 AND n.inscrire.classe.classId=?2 AND n.semestre.semId=?3")
	public long sommenc(long id,long classId,long semId);
	@Query("SELECT SUM(coef) FROM Note as n WHERE n.inscrire.etudiant.id=?1 AND n.inscrire.classe.classId=?2 AND n.semestre.semId=?3")
	public long sommec(long id,long classId,long semId);
	

}
