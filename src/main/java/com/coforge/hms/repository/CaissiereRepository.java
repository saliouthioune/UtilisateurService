package com.coforge.hms.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coforge.hms.model.*;
@Repository
public interface CaissiereRepository extends JpaRepository<Caissiere,Long>{

}
