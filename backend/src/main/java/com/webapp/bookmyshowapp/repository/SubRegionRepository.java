package com.webapp.bookmyshowapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.bookmyshowapp.model.SubRegion;

@Repository
@Transactional(readOnly=true)
public interface SubRegionRepository extends JpaRepository<SubRegion,Long>{
	
	SubRegion findByRegionName(String regionName);
	
}
