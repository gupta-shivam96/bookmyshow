package com.webapp.bookmyshowapp.repository;

import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.bookmyshowapp.model.Show;

@Repository
@Transactional(readOnly=true)
public interface ShowRepository extends JpaRepository<Show,Long>{
	
	Show findById(long id);
	
	Show findByShowTime(LocalTime showTime);
}
