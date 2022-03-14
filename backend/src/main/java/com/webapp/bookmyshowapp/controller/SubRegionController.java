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
import com.webapp.bookmyshowapp.exceptions.CityException;
import com.webapp.bookmyshowapp.exceptions.DaoException;
import com.webapp.bookmyshowapp.exceptions.SubRegionException;
import com.webapp.bookmyshowapp.form.SubRegionCreateForm;
import com.webapp.bookmyshowapp.model.SubRegion;
import com.webapp.bookmyshowapp.service.SubRegionService;
import com.webapp.bookmyshowapp.util.BaseExceptionHandler;
import com.webapp.bookmyshowapp.util.LogConstantUtil;
import com.webapp.bookmyshowapp.util.SubRegionUtil;

@RestController
@RequestMapping(RestEndPoints.PARENTAPI)
public class SubRegionController extends BaseExceptionHandler{
	
	Logger log = LoggerFactory.getLogger(SubRegionController.class);
	
	@Autowired
	SubRegionService subRegionService;
	
	@Autowired
	SubRegionUtil subRegionUtil;
	
	@PostMapping(RestEndPoints.CREATE_SUBREGION)
	public ResponseEntity<Object> createSubRegion(@RequestBody SubRegionCreateForm subRegionCreateForm){
		
		List<String> validationErrorList = new ArrayList<String>();
		SubRegion subRegion = null;
		
		try {
			log.info("Validating SubRegionCreateForm");
			validationErrorList = subRegionUtil.validate(subRegionCreateForm, validationErrorList);
			log.info("SubRegion Create Form Validation Completed");
			if(!validationErrorList.isEmpty()) {
				log.error(" Error occuured while validating subRegionCreateForm || " + LogConstantUtil.LOG_VALIDATION_ERRORLIST, validationErrorList);
				return handle400BadRequest(validationErrorList);
			}
			subRegion = subRegionService.saveSubRegion(subRegionCreateForm);
		}catch(CityException ce) {
			log.error("No city exist for the given names in request" + LogConstantUtil.LOG_SUBREGION_EXCEPTION, ce);
			return handle404ResourceNotFoundRequest(ConstantUtil.ERROR_CITY_NOT_FOUND, ce);
		}catch(SubRegionException se) {
			log.error("Exception occured while validating subregion Create Form in subregionUtil " +LogConstantUtil.LOG_SUBREGION_EXCEPTION,se);
            return handle400BadRequest(ConstantUtil.ERROR_SUBREGION_CREATE,se);
		}catch(DaoException de) {
			log.error("Exception occured while creating subregion record in db " +LogConstantUtil.LOG_DAO_EXCEPTION, de);
			return handle602DatabaseError(ConstantUtil.ERROR_SUBREGION_CREATE,de);
		}catch(Exception ex) {
			log.error("Exception Occured While creating subregion record " + LogConstantUtil.LOG_DBDOWN_AND_OTHER_EXCEPTION, ex);
			return handle500InternalServerError(ConstantUtil.ERROR_SUBREGION_CREATE,ex);
		}
		return handle200OkRequest(subRegion);
	}
}
