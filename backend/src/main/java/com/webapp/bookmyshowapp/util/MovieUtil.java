package com.webapp.bookmyshowapp.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webapp.bookmyshowapp.enums.CertificateType;
import com.webapp.bookmyshowapp.enums.Genre;
import com.webapp.bookmyshowapp.enums.MovieLanguage;
import com.webapp.bookmyshowapp.exceptions.MovieException;
import com.webapp.bookmyshowapp.form.MovieCreateForm;
import com.webapp.bookmyshowapp.model.Movie;
import com.webapp.bookmyshowapp.service.CastService;
import com.webapp.bookmyshowapp.validations.MovieValidation;

@Component
public class MovieUtil extends DateUtil{
	
	Logger log = LoggerFactory.getLogger(MovieUtil.class);
	
	@Autowired
	MovieValidation movieValidation;
	
	@Autowired
	CastService castService;
	
	/*
	 * validate Movie
	 * 
	 * @param movie
	 * @param validationErrorList
	 * @return
	 * 
	 */
	
	public List<String> validate(MovieCreateForm movieCreateForm, List<String> validationErrorList) throws MovieException{
		try {
			return movieValidation.validate(movieCreateForm, validationErrorList);
		}catch(Exception e) {
			throw new MovieException(e.getMessage());
		}
	}
	
	/*
	 * create movie
	 * 
	 * @param movie
	 * @param createMovieForm
	 * @return
	 * 
	 */
	
	public Movie createMovie(MovieCreateForm movieCreateForm) throws Exception{
		log.info("Setting Values for Movie from MovieCreateForm");
		Movie movie = new Movie();
		try {
			movie.setName(movieCreateForm.getName());
			movie.setScreenType(movieCreateForm.getScreenType());
			movie.setLanguage(MovieLanguage.valueOf(movieCreateForm.getLanguage()));
			movie.setDuration(movieCreateForm.getDuration());
			movie.setReleaseDate(movieCreateForm.getReleaseDate());
			movie.setGenre(Genre.valueOf(movieCreateForm.getGenre()));
			movie.setCertificateType(CertificateType.valueOf(movieCreateForm.getCertificateType()));
			movie.setImageName(movieCreateForm.getImageName());
			movie.setBackgroundImageName(movieCreateForm.getBackgroundImageName());
			movie.setRating(movieCreateForm.getRating());
			movie.setCreated(getCurrentDateAndTime());
			movie.setCreated(getCurrentDateAndTime());
		}catch(Exception ex) {
			throw ex;
		}
		log.info("value setting in movie completed");
		return movie;
	}
}
