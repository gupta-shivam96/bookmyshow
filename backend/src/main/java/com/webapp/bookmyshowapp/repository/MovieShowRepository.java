package com.webapp.bookmyshowapp.repository;

import java.time.LocalTime;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.bookmyshowapp.model.MovieShow;
import com.webapp.bookmyshowapp.model.MovieShowId;
import com.webapp.bookmyshowapp.model.Show;

@Repository
@Transactional(readOnly=true)
public interface MovieShowRepository extends JpaRepository<MovieShow,MovieShowId>{
	

	@Query("Select ms.show FROM MovieShow ms where ms.movie.name = :movieName and ms.show.showTime > :currentTime")
	Set<Show> getAllShowsByMovie(@Param("movieName") String movieName,@Param("currentTime") LocalTime currentTime);
	
	@Query("Select ms.show FROM MovieShow ms where ms.movie.name = :movieName")
	Set<Show> getAllShowsByMovie(@Param("movieName") String movieName);
}
