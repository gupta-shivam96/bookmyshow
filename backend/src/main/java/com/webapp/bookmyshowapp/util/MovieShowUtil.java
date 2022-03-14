package com.webapp.bookmyshowapp.util;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webapp.bookmyshowapp.exceptions.MovieException;
import com.webapp.bookmyshowapp.exceptions.MovieShowException;
import com.webapp.bookmyshowapp.exceptions.ShowException;
import com.webapp.bookmyshowapp.form.MovieShowCreateForm;
import com.webapp.bookmyshowapp.model.Movie;
import com.webapp.bookmyshowapp.model.MovieShow;
import com.webapp.bookmyshowapp.model.Show;
import com.webapp.bookmyshowapp.repository.MovieRepository;
import com.webapp.bookmyshowapp.repository.ShowRepository;
import com.webapp.bookmyshowapp.validations.MovieShowValidation;

@Component
public class MovieShowUtil {

	Logger log = LoggerFactory.getLogger(MovieShowUtil.class);
	
	@Autowired
	MovieShowValidation movieShowValidation;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	ShowRepository showRepository;
	
	/*
	 * validate MovieShow
	 * 
	 * @param movieshow
	 * @param validationErrorList
	 * @return
	 * 
	 */
	
	public List<String> validate(MovieShowCreateForm movieShowCreateForm, List<String> validationErrorList) throws MovieShowException{
		try {
			return movieShowValidation.validate(movieShowCreateForm, validationErrorList);
		}catch(Exception e) {
			throw new MovieShowException(e.getMessage());
		}
	}
	
	
	public MovieShow createMovieShow(MovieShowCreateForm movieShowCreateForm) throws Exception{
		log.info("Setting Values for Movie from MovieShowCreateForm");
		MovieShow movieShow = null;
		try {
			Movie movie = movieRepository.findById(movieShowCreateForm.getMovieId().longValue());
			if(Objects.isNull(movie)) {
				throw new MovieException("Movie Not Found For ID : " + movieShowCreateForm.getMovieId().longValue());
			}
			Show show = showRepository.findById(movieShowCreateForm.getShowId().longValue());
			if(Objects.isNull(movie)) {
				throw new ShowException("Show Not Found For ID : " + movieShowCreateForm.getShowId().longValue());
			}
			movieShow = new MovieShow(movie,show);
		}catch(Exception ex) {
			throw ex;
		}
		log.info("value setting in movie completed");
		return movieShow;
	}
}
