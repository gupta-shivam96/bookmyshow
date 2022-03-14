package com.webapp.bookmyshowapp.service;

import java.util.Set;

import com.webapp.bookmyshowapp.form.TheaterMovieCreateForm;
import com.webapp.bookmyshowapp.model.Movie;
import com.webapp.bookmyshowapp.model.Theater;
import com.webapp.bookmyshowapp.model.TheaterMovie;

public interface TheaterMovieService {

	TheaterMovie createTheaterMovie(TheaterMovieCreateForm theaterMovieCreateForm) throws Exception;
	
	Set<Movie> getAllMoviesByCity(String cityName);
	
	Set<Theater> getAllTheatersByCityAndMovie(String cityName,String movieName);
	
	Set<Theater> getAllTheatersByCityAndRegionAndMovie(String cityName,String regionName,String movieName);
	
	
}
