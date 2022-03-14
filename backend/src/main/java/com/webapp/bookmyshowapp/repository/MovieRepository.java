package com.webapp.bookmyshowapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.bookmyshowapp.model.Movie;

@Repository
@Transactional(readOnly=true)
public interface MovieRepository extends JpaRepository<Movie,Long>{
	
	Movie findById(long id);
	
	Movie findByName(String name);
}
