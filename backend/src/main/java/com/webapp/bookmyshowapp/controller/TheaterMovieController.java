package com.webapp.bookmyshowapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.bookmyshowapp.constant.ConstantUtil;
import com.webapp.bookmyshowapp.constant.RestEndPoints;
import com.webapp.bookmyshowapp.exceptions.MovieException;
import com.webapp.bookmyshowapp.exceptions.TheaterException;
import com.webapp.bookmyshowapp.form.TheaterMovieCreateForm;
import com.webapp.bookmyshowapp.model.TheaterMovie;
import com.webapp.bookmyshowapp.service.TheaterMovieService;
import com.webapp.bookmyshowapp.util.BaseExceptionHandler;
import com.webapp.bookmyshowapp.util.LogConstantUtil;
import com.webapp.bookmyshowapp.util.TheaterMovieUtil;

@RestController
@RequestMapping(RestEndPoints.PARENTAPI)
public class TheaterMovieController extends BaseExceptionHandler{
	
	Logger log = LoggerFactory.getLogger(TheaterMovieController.class);
	
	@Autowired
	TheaterMovieService theaterMovieService;
	 
	@Autowired
	TheaterMovieUtil theaterMovieUtil;
	 
	@PostMapping(RestEndPoints.CREATE_THEATER_MOVIE)
	public ResponseEntity<Object> createTheaterMovie(@RequestBody TheaterMovieCreateForm theaterMovieCreateForm){
		List<String> validationErrorList = new ArrayList<String>();
		TheaterMovie theaterMovie =null;
		try {
			log.info("Validating TheaterCreateForm");
			validationErrorList = theaterMovieUtil.validate(theaterMovieCreateForm, validationErrorList);
			log.info("TheaterMovie Create Form Validation Completed");
			if(!validationErrorList.isEmpty()) {
				log.error(" Error occuured while validating theaterMovieCreateForm || " + LogConstantUtil.LOG_VALIDATION_ERRORLIST, validationErrorList);
				return handle400BadRequest(validationErrorList);
			} 
			theaterMovie=theaterMovieService.createTheaterMovie(theaterMovieCreateForm);
			
		}catch(MovieException me) {
			log.error("No movie exist for the given name in request" +LogConstantUtil.LOG_MOVIE_EXCEPTION,me);
			return handle404ResourceNotFoundRequest(ConstantUtil.ERROR_MOVIE_NOT_FOUND,me);
	    }catch(TheaterException ce) {
			log.error("No Theater exist for the given name in request" +LogConstantUtil.LOG_THEATER_EXCEPTION,ce);
			return handle404ResourceNotFoundRequest(ConstantUtil.ERROR_THEATER_NOT_FOUND,ce);
	    }catch(Exception ex) {
	    	log.error("Exception Occured While creating theatermovie record " + LogConstantUtil.LOG_DBDOWN_AND_OTHER_EXCEPTION, ex);
	    	return handle500InternalServerError(ConstantUtil.ERROR_THEATER_MOVIE_CREATE,ex);
		}
		return handle200OkRequest(theaterMovie);
	}

}
