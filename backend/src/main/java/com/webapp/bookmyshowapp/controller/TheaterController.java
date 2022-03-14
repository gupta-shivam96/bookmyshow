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
import com.webapp.bookmyshowapp.exceptions.DaoException;
import com.webapp.bookmyshowapp.exceptions.SubRegionException;
import com.webapp.bookmyshowapp.form.TheaterCreateForm;
import com.webapp.bookmyshowapp.model.Theater;
import com.webapp.bookmyshowapp.service.TheaterService;
import com.webapp.bookmyshowapp.util.BaseExceptionHandler;
import com.webapp.bookmyshowapp.util.LogConstantUtil;
import com.webapp.bookmyshowapp.util.TheaterUtil;

@RestController
@RequestMapping(RestEndPoints.PARENTAPI)
public class TheaterController extends BaseExceptionHandler{
	
	Logger log = LoggerFactory.getLogger(TheaterController.class);
	
	@Autowired
	TheaterService theaterService;
	
	@Autowired
	TheaterUtil theaterUtil;
	
	@PostMapping(RestEndPoints.CREATE_THEATER)
	public ResponseEntity<Object> createTheater(@RequestBody TheaterCreateForm theaterCreateForm){
		List<String> validationErrorList = new ArrayList<String>();
		Theater theater = null;
		try {
			log.info("Validating TheaterCreateForm");
			validationErrorList = theaterUtil.validate(theaterCreateForm, validationErrorList);
			if(!validationErrorList.isEmpty()) {
				log.error(" Error occuured while validating theaterCreateForm || " + LogConstantUtil.LOG_VALIDATION_ERRORLIST, validationErrorList);
				return handle400BadRequest(validationErrorList);
			}
			theater = theaterService.createTheater(theaterCreateForm);
			
		}catch(SubRegionException se) {
			log.error("No subregion exist for the given name in request" + LogConstantUtil.LOG_THEATER_EXCEPTION, se);
			return handle404ResourceNotFoundRequest(ConstantUtil.ERROR_SUBREGION_NOT_FOUND, se);
		}catch(DaoException de) {
			log.error("Exception occured while creating subregion record in db " +LogConstantUtil.LOG_DAO_EXCEPTION, de);
			return handle602DatabaseError(ConstantUtil.ERROR_THEATER_CREATE,de);
		}catch(Exception ex) {
			log.error("Exception Occured While creating theater record " + LogConstantUtil.LOG_DBDOWN_AND_OTHER_EXCEPTION, ex);
			return handle500InternalServerError(ConstantUtil.ERROR_THEATER_CREATE,ex);
		}
		return handle200OkRequest(theater);
	}
}
