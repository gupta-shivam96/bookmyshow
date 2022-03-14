package com.webapp.bookmyshowapp.serviceimpl;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.bookmyshowapp.form.TheaterMovieCreateForm;
import com.webapp.bookmyshowapp.model.Movie;
import com.webapp.bookmyshowapp.model.Theater;
import com.webapp.bookmyshowapp.model.TheaterMovie;
import com.webapp.bookmyshowapp.repository.TheaterMovieRepository;
import com.webapp.bookmyshowapp.service.TheaterMovieService;
import com.webapp.bookmyshowapp.util.TheaterMovieUtil;

@Service
public class TheaterMovieServiceImpl implements TheaterMovieService{

	Logger log = LoggerFactory.getLogger(TheaterMovieServiceImpl.class);

	@Autowired
	TheaterMovieRepository theaterMovieRepository;
	
	@Autowired
	TheaterMovieUtil theaterMovieUtil;
	
	
	@Override
	@Transactional
	public TheaterMovie createTheaterMovie(TheaterMovieCreateForm theaterMovieCreateForm) throws Exception {
		// TODO Auto-generated method stub
		TheaterMovie theaterMovie = null;
		try {
			theaterMovie = theaterMovieUtil.createTheaterMovie(theaterMovieCreateForm);
			log.info("Persisting theatermovie record in db");
			theaterMovie=theaterMovieRepository.save(theaterMovie);
			log.info("Persisted theatermovie record in db successfully with id : " + theaterMovie.getId());
		}catch(Exception ex) {
			throw ex;
		}
		return theaterMovie;
	}


	@Override
	public Set<Movie> getAllMoviesByCity(String cityName) {
		// TODO Auto-generated method stub
		Set<Movie> movies=null;
		try {
			movies = theaterMovieRepository.getAllMoviesByCity(cityName);
		}catch(Exception ex) {
			throw ex;
		}
		return movies;
	}


	@Override
	public Set<Theater> getAllTheatersByCityAndMovie(String cityName,String movieName) {
		// TODO Auto-generated method stub
		Set<Theater> theaters=null;
		try {
			theaters = theaterMovieRepository.getAllTheatersByCityAndMovie(cityName,movieName);
		}catch(Exception ex) {
			throw ex;
		}
		return theaters;
	}


	@Override
	public Set<Theater> getAllTheatersByCityAndRegionAndMovie(String cityName,String regionName,String movieName) {
		// TODO Auto-generated method stub
		Set<Theater> theaters=null;
		try {
			theaters = theaterMovieRepository.getAllTheatersByCityAndRegionAndMovie(cityName,regionName,movieName);
		}catch(Exception ex) {
			throw ex;
		}
		return theaters;
	}
	
	

}
