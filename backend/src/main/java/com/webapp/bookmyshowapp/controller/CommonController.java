package com.webapp.bookmyshowapp.controller;

import java.util.Objects;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.bookmyshowapp.bean.ShowAvailiabilityResponseBean;
import com.webapp.bookmyshowapp.constant.ConstantUtil;
import com.webapp.bookmyshowapp.constant.RestEndPoints;
import com.webapp.bookmyshowapp.form.ShowAvailiabilityFetchForm;
import com.webapp.bookmyshowapp.model.Movie;
import com.webapp.bookmyshowapp.model.Show;
import com.webapp.bookmyshowapp.model.Theater;
import com.webapp.bookmyshowapp.service.MovieShowService;
import com.webapp.bookmyshowapp.service.TheaterMovieService;
import com.webapp.bookmyshowapp.service.TicketService;
import com.webapp.bookmyshowapp.util.BaseExceptionHandler;
import com.webapp.bookmyshowapp.util.LogConstantUtil;

@RestController
@RequestMapping(RestEndPoints.PARENTAPI)
public class CommonController extends BaseExceptionHandler{
	
	Logger log = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	TheaterMovieService theaterMovieService;
	
	@Autowired
	MovieShowService movieShowService;

	@Autowired
	TicketService ticketService;
	
	@GetMapping(RestEndPoints.GET_MOVEIS_BY_CITY)
	public ResponseEntity<Object> getMoviesByCity(@PathVariable("city_name") String cityName){
		Set<Movie> movies = null;
		try {
			movies = theaterMovieService.getAllMoviesByCity(cityName);
			if(Objects.isNull(movies) || movies.isEmpty()) {
				return handle404ResourceNotFoundRequest(ConstantUtil.ERROR_MOVIE_NOT_FOUND);
			}
		}catch(Exception ex) {
			log.error("Exception Occured While geting movies " + LogConstantUtil.LOG_DBDOWN_AND_OTHER_EXCEPTION, ex);
	    	return handle500InternalServerError(ConstantUtil.ERROR_MOVIE_NOT_FOUND,ex);
		}
		return handle200OkRequest(movies);
	}
	
	@GetMapping(RestEndPoints.GET_THEATERS_BY_CITY_MOVIE)
	public ResponseEntity<Object> getAllTheatersByCityAndMovie(@PathVariable("city_name") String cityName,@PathVariable("movie_name") String movieName){
		Set<Theater> theaters = null;
		try {
			theaters = theaterMovieService.getAllTheatersByCityAndMovie(cityName,movieName);
			if(Objects.isNull(theaters) || theaters.isEmpty()) {
				return handle404ResourceNotFoundRequest(ConstantUtil.ERROR_THEATER_NOT_FOUND);
			}
		}catch(Exception ex) {
			log.error("Exception Occured While geting theaters " + LogConstantUtil.LOG_DBDOWN_AND_OTHER_EXCEPTION, ex);
	    	return handle500InternalServerError(ConstantUtil.ERROR_THEATER_NOT_FOUND,ex);
		}
		return handle200OkRequest(theaters);
	}
	

	@GetMapping(RestEndPoints.GET_THEATERS_BY_CITY_REGION_MOVIE)
	public ResponseEntity<Object> getAllTheatersByCityAndRegionAndMovie(@PathVariable("city_name") String cityName,@PathVariable("region_name") String regionName,@PathVariable("movie_name") String movieName){
		Set<Theater> theaters = null;
		try {
			theaters = theaterMovieService.getAllTheatersByCityAndRegionAndMovie(cityName,regionName,movieName);
			if(Objects.isNull(theaters) || theaters.isEmpty()) {
				return handle404ResourceNotFoundRequest(ConstantUtil.ERROR_THEATER_NOT_FOUND);
			}
		}catch(Exception ex) {
			log.error("Exception Occured While geting theaters " + LogConstantUtil.LOG_DBDOWN_AND_OTHER_EXCEPTION, ex);
	    	return handle500InternalServerError(ConstantUtil.ERROR_THEATER_NOT_FOUND,ex);
		}
		return handle200OkRequest(theaters);
	}
	
	@GetMapping(RestEndPoints.GET_SHOWS_BY_MOVIE)
	public ResponseEntity<Object> getAllTheatersByCityAndRegionAndMovie(@PathVariable("movie_name") String movieName,@PathVariable("show_date") String showDate ){
		Set<Show> shows = null;
		try {
			log.info("Show Date : " + showDate);
			shows = movieShowService.getShowsByMovie(movieName,showDate);
		}catch(Exception ex) {
			log.error("Exception Occured While geting shows " + LogConstantUtil.LOG_DBDOWN_AND_OTHER_EXCEPTION, ex);
	    	return handle500InternalServerError(ConstantUtil.ERROR_SHOW_NOT_FOUND,ex);
		}
		return handle200OkRequest(shows);
	}
	
	@PostMapping(RestEndPoints.POST_SHOW_AVAILIBILITY)
	public ResponseEntity<Object> getAllTheatersByCityAndRegionAndMovie(@Valid @RequestBody ShowAvailiabilityFetchForm showAvailiabilityFetchForm){
		ShowAvailiabilityResponseBean showAvailiabilityResponseBean = null;
		try {
			showAvailiabilityResponseBean = ticketService.getShowAvailiability(showAvailiabilityFetchForm);
			
		}catch(Exception ex) {
			log.error("Exception Occured While geting ShowAvailiability " + LogConstantUtil.LOG_DBDOWN_AND_OTHER_EXCEPTION, ex);
	    	return handle500InternalServerError(ConstantUtil.ERROR_GET_SHOW_AVAILIABILITY,ex);		
		}
		return handle200OkRequest(showAvailiabilityResponseBean);
	}
}
