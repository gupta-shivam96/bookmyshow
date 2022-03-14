package com.webapp.bookmyshowapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.bookmyshowapp.model.Theater;

@Repository
@Transactional(readOnly=true)
public interface TheaterRepository extends JpaRepository<Theater,Long>{

	Theater findByName(String name);
	
	Theater findById(long id);
}
