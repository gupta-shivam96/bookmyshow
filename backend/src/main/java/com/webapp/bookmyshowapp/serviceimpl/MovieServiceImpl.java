package com.webapp.bookmyshowapp.serviceimpl;

import java.util.Set;

import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.bookmyshowapp.exceptions.DaoException;
import com.webapp.bookmyshowapp.form.MovieCreateForm;
import com.webapp.bookmyshowapp.model.Movie;
import com.webapp.bookmyshowapp.repository.MovieRepository;
import com.webapp.bookmyshowapp.service.MovieService;
import com.webapp.bookmyshowapp.util.MovieUtil;

@Service
public class MovieServiceImpl implements MovieService{

	Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);
	
	@Autowired
	MovieUtil movieUtil;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Override
	@Transactional
	public Movie saveMovie(MovieCreateForm movieCreateForm) throws Exception {
		// TODO Auto-generated method stub
		Movie movie = null;
		try {
			movie = movieUtil.createMovie(movieCreateForm);
			log.info("Persisting movie record in db");
			movie = movieRepository.save(movie);
			log.info("Persisted movie record in db successfully with id : " + movie.getId());
		}catch(PersistenceException de) {
			throw new DaoException(de);
		}catch(Exception ex) {
			throw ex;
		}
		return movie;
	}

	@Override
	public Set<Movie> findAllMoviesByNames(Set<String> movieNames) {
		// TODO Auto-generated method stub
		Set<Movie> movies=null;
		try {
			log.info("Fetching movies from db for nams : " + movieNames);
			
		}catch(PersistenceException de) {
			throw new DaoException(de);
		}catch(Exception ex) {
			throw ex;
		}
		return movies;
	}

	@Override
	public Movie getMovie(long id) {
		// TODO Auto-generated method stub
		Movie movie = null;
		try {
			log.info("Fetching movie from database for id : " + id);
			movie = movieRepository.findById(id);
			log.info("Movie fetched from database successfully for id : " + id);
		}catch(Exception ex) {
			throw ex;
		}
		return movie;
	}

}
