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
import com.webapp.bookmyshowapp.exceptions.ShowException;
import com.webapp.bookmyshowapp.form.ShowCreateForm;
import com.webapp.bookmyshowapp.model.Show;
import com.webapp.bookmyshowapp.service.ShowService;
import com.webapp.bookmyshowapp.util.BaseExceptionHandler;
import com.webapp.bookmyshowapp.util.LogConstantUtil;
import com.webapp.bookmyshowapp.util.ShowUtil;

@RestController
@RequestMapping(RestEndPoints.PARENTAPI)
public class ShowController extends BaseExceptionHandler {
	
	Logger log = LoggerFactory.getLogger(ShowController.class);
	
	@Autowired
	ShowUtil showUtil;
	
	@Autowired
	ShowService showService;
	
	@PostMapping(RestEndPoints.CREATE_SHOW)
	public ResponseEntity<Object> createShow(@RequestBody ShowCreateForm showCreateForm){
		List<String> validationErrorList = new ArrayList<String>();
		Show show = null;
		try {
			log.info("Validating ShowCreateForm");
			validationErrorList = showUtil.validate(showCreateForm, validationErrorList);
			log.info("Movie Show Form Validation Completed");
			if(!validationErrorList.isEmpty()) {
				log.error(" Error occuured while validating showCreateForm || " + LogConstantUtil.LOG_VALIDATION_ERRORLIST, validationErrorList);
				return handle400BadRequest(validationErrorList);
			}
			
			show=showService.saveShow(showCreateForm);
		}catch(ShowException se) {
			log.error("Exception occured while validating show Create Form in showutil " +LogConstantUtil.LOG_SHOW_EXCEPTION,se);
			return handle400BadRequest(ConstantUtil.ERROR_SHOW_CREATE,se);
		}catch(DaoException de) {
			log.error("Exception occured while creating show record in db " +LogConstantUtil.LOG_DAO_EXCEPTION, de);
			return handle602DatabaseError(ConstantUtil.ERROR_SHOW_CREATE,de);
		}catch(Exception ex) {
			log.error("Exception Occured While creating show record " + LogConstantUtil.LOG_DBDOWN_AND_OTHER_EXCEPTION, ex);
			return handle500InternalServerError(ConstantUtil.ERROR_SHOW_CREATE,ex);
		}
		return handle200OkRequest(show);
	}



}
