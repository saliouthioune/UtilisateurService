package com.coforge.hms.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.coforge.hms.model.*;
@Repository
public interface CourRepository extends JpaRepository<Cour,Long>{
	
}
