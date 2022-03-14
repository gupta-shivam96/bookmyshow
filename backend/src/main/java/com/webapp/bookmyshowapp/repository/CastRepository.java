package com.webapp.bookmyshowapp.repository;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.bookmyshowapp.model.Casting;

@Repository
@Transactional(readOnly=true)
public interface CastRepository extends JpaRepository<Casting,Long>{
	
	@Query("FROM Casting c WHERE c.castName in (:castings)")
	Set<Casting> findAllCastingByNames(@Param("castings") Set<String> castNames);

}


