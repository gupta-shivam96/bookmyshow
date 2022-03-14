package com.webapp.bookmyshowapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.bookmyshowapp.model.City;

@Repository
@Transactional(readOnly=true)
public interface CityRepository extends JpaRepository<City,Long>{
	
	City findById(long id);
	
	City findByName(String name);
}
