package com.webapp.bookmyshowapp.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.bookmyshowapp.model.Movie;
import com.webapp.bookmyshowapp.model.Theater;
import com.webapp.bookmyshowapp.model.TheaterMovie;
import com.webapp.bookmyshowapp.model.TheaterMovieId;

@Repository
@Transactional(readOnly=true)
public interface TheaterMovieRepository extends JpaRepository<TheaterMovie,TheaterMovieId>{
	
	@Query("Select tm.movie FROM TheaterMovie tm where tm.theater.subRegion.city.name = :cityName")
	Set<Movie> getAllMoviesByCity(@Param("cityName") String cityName);
	
	@Query("Select tm.theater FROM TheaterMovie tm where tm.theater.subRegion.city.name = :cityName and tm.movie.name = :movieName")
	Set<Theater> getAllTheatersByCityAndMovie(@Param("cityName") String cityName, @Param("movieName") String movieName);
	
	@Query("Select tm.theater FROM TheaterMovie tm where tm.theater.subRegion.city.name = :cityName and tm.theater.subRegion.regionName = :regionName and tm.movie.name = :movieName")
	Set<Theater> getAllTheatersByCityAndRegionAndMovie(@Param("cityName") String cityName,@Param("regionName") String regionName, @Param("movieName") String movieName);
}
