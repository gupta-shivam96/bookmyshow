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
import com.webapp.bookmyshowapp.exceptions.ShowException;
import com.webapp.bookmyshowapp.form.MovieShowCreateForm;
import com.webapp.bookmyshowapp.model.MovieShow;
import com.webapp.bookmyshowapp.service.MovieShowService;
import com.webapp.bookmyshowapp.util.BaseExceptionHandler;
import com.webapp.bookmyshowapp.util.LogConstantUtil;
import com.webapp.bookmyshowapp.util.MovieShowUtil;

@RestController
@RequestMapping(RestEndPoints.PARENTAPI)
public class MovieShowController extends BaseExceptionHandler{
	
	Logger log = LoggerFactory.getLogger(MovieShowController.class);
	
	@Autowired
	MovieShowService movieShowService;
	 
	@Autowired
	MovieShowUtil movieShowUtil;
	
	@PostMapping(RestEndPoints.CREATE_MOVIE_SHOW)
	public ResponseEntity<Object> createMovieShow(@RequestBody MovieShowCreateForm movieShowCreateForm){
		List<String> validationErrorList = new ArrayList<String>();
		MovieShow movieShow = null;
		try {
			log.info("Validating MovieShowCreateForm");
			validationErrorList = movieShowUtil.validate(movieShowCreateForm, validationErrorList);
			log.info("MovieShow Create Form Validation Completed");
			if(!validationErrorList.isEmpty()) {
				log.error(" Error occuured while validating movieShowCreateForm || " + LogConstantUtil.LOG_VALIDATION_ERRORLIST, validationErrorList);
				return handle400BadRequest(validationErrorList);
			} 
			movieShow=movieShowService.createMovieShow(movieShowCreateForm);
		}catch(MovieException me) {
			log.error("No movie exist for the given Id in request" +LogConstantUtil.LOG_MOVIE_EXCEPTION,me);
			return handle404ResourceNotFoundRequest(ConstantUtil.ERROR_MOVIE_NOT_FOUND,me);
	    }catch(ShowException se) {
			log.error("No Show exist for the given Id in request" +LogConstantUtil.LOG_SHOW_EXCEPTION,se);
			return handle404ResourceNotFoundRequest(ConstantUtil.ERROR_SHOW_NOT_FOUND,se);
	    }catch(Exception ex) {
	    	log.error("Exception Occured While creating movieshow record " + LogConstantUtil.LOG_DBDOWN_AND_OTHER_EXCEPTION, ex);
	    	return handle500InternalServerError(ConstantUtil.ERROR_MOVIE_SHOW_CREATE,ex);
		}
		return handle200OkRequest(movieShow);
	}
}
