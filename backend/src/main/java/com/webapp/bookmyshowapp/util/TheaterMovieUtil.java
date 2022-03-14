package com.webapp.bookmyshowapp.util;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webapp.bookmyshowapp.exceptions.MovieException;
import com.webapp.bookmyshowapp.exceptions.TheaterException;
import com.webapp.bookmyshowapp.exceptions.TheaterMovieException;
import com.webapp.bookmyshowapp.form.TheaterMovieCreateForm;
import com.webapp.bookmyshowapp.model.Movie;
import com.webapp.bookmyshowapp.model.Theater;
import com.webapp.bookmyshowapp.model.TheaterMovie;
import com.webapp.bookmyshowapp.repository.MovieRepository;
import com.webapp.bookmyshowapp.repository.TheaterRepository;
import com.webapp.bookmyshowapp.validations.TheaterMovieValidation;

@Component
public class TheaterMovieUtil extends DateUtil{

	  Logger log = LoggerFactory.getLogger(CityUtil.class);
	    

	  @Autowired
	  TheaterMovieValidation theaterMovieValidation;

	  @Autowired
	  TheaterRepository theaterRepository;
	  
	  @Autowired
	  MovieRepository movieRepository;
	  
	  /*
	     * validate CityMovie
	     *
	     * @param citymovie
	     * @param validationErrorList
	     * @return
	     *
	     */

	    public List<String> validate(TheaterMovieCreateForm theaterMovieCreateForm, List<String> validationErrorList) throws TheaterMovieException {
	        try {
	            return theaterMovieValidation.validate(theaterMovieCreateForm, validationErrorList);
	        }catch(Exception e) {
	            throw new TheaterMovieException(e.getMessage());
	        }
	    }
	    
	    /*
	     *Theater Movie
	     *Create
	     */

	    public TheaterMovie createTheaterMovie(TheaterMovieCreateForm theaterMovieCreateForm) throws Exception{
	        log.info("Setting Values for TheaterMovie from TheaterMovieCreateForm");
	        TheaterMovie theaterMovie = null;
	        try {
	        	Theater theater = theaterRepository.findByName(theaterMovieCreateForm.getTheaterName());
				if(Objects.isNull(theater)) {
					throw new TheaterException("Theater Not Found For Name : " + theaterMovieCreateForm.getTheaterName());
				}
				Movie movie = movieRepository.findByName(theaterMovieCreateForm.getMovieName());
				if(Objects.isNull(movie)) {
					throw new MovieException("Movie Not Found For Name : " + theaterMovieCreateForm.getMovieName());
				}
				theaterMovie = new TheaterMovie(theater,movie);
	        }catch(Exception ex) {
	            throw ex;
	        }
	        log.info("value setting in TheaterMovie completed");
	        return  theaterMovie;
	    }


}
