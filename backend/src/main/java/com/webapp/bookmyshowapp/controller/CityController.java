package com.webapp.bookmyshowapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

import com.webapp.bookmyshowapp.constant.ConstantUtil;
import com.webapp.bookmyshowapp.constant.RestEndPoints;
import com.webapp.bookmyshowapp.exceptions.CityException;
import com.webapp.bookmyshowapp.exceptions.DaoException;
import com.webapp.bookmyshowapp.form.CityCreateForm;
import com.webapp.bookmyshowapp.model.City;
import com.webapp.bookmyshowapp.service.CityService;
import com.webapp.bookmyshowapp.util.BaseExceptionHandler;
import com.webapp.bookmyshowapp.util.CityUtil;
import com.webapp.bookmyshowapp.util.LogConstantUtil;

@RestController
@RequestMapping(RestEndPoints.PARENTAPI)
public class CityController extends BaseExceptionHandler {

	Logger log = LoggerFactory.getLogger(CityController.class);

    @Autowired
    CityUtil cityUtil;

    @Autowired
    CityService cityService;

 
    @PostMapping(RestEndPoints.CREATE_CITY)
    public ResponseEntity<Object> createCity(@RequestBody CityCreateForm cityCreateForm){
        List<String> validationErrorList = new ArrayList<String>();
        City city = null;
        try {
            log.info("Validating CityCreateForm");
            validationErrorList = cityUtil.validate(cityCreateForm, validationErrorList);
            log.info("City Create Form Validation Completed");
            if(!validationErrorList.isEmpty()) {
                log.error(" Error occuured while validating cityCreateForm || " + LogConstantUtil.LOG_VALIDATION_ERRORLIST, validationErrorList);
                return handle400BadRequest(validationErrorList);
            }
            city=cityService.saveCity(cityCreateForm);
        }catch(CityException ce) {
            log.error("Exception occured while validating city Create Form in cityUtil " +LogConstantUtil.LOG_CITY_EXCEPTION,ce);
            return handle400BadRequest(ConstantUtil.ERROR_CITY_CREATE,ce);
        }catch(DaoException de) {
            log.error("Exception occured while creating city record in db " +LogConstantUtil.LOG_DAO_EXCEPTION, de);
            return handle602DatabaseError(ConstantUtil.ERROR_CITY_CREATE,de);
        }catch(Exception ex) {
        	log.error("Exception Occured While creating city record " + LogConstantUtil.LOG_DBDOWN_AND_OTHER_EXCEPTION, ex);
			return handle500InternalServerError(ConstantUtil.ERROR_CITY_CREATE,ex);
        }
        return handle200OkRequest(city);
    }
    
    
    @GetMapping(RestEndPoints.GET_CITY_BY_ID)
    public ResponseEntity<Object> getCity(@PathVariable("id") long id){
        City city = null;
        try {
            city = cityService.getCity(id);
            if(Objects.isNull(city)) {
				return handle404ResourceNotFoundRequest(ConstantUtil.ERROR_CITY_NOT_FOUND);
			}
        }catch(DaoException de) {
            log.error("Exception occured while fetching single city record in db " + LogConstantUtil.LOG_DAO_EXCEPTION, de);
            return handle602DatabaseError(ConstantUtil.ERROR_CITY_FETCH, de);
        }catch(Exception ex) {
            log.error("Error occured while fetching city from database",ex);
            return handle500InternalServerError(ConstantUtil.ERROR_CITY_FETCH,ex);
        }
        return handle200OkRequest(city);
    }
    
    @GetMapping(RestEndPoints.GET_ALL_CITY)
    public ResponseEntity<Object> getCity(){
        List<City> cities = null;
        try {
            cities = cityService.getAllCities();
            if(Objects.isNull(cities)) {
				return handle404ResourceNotFoundRequest(ConstantUtil.ERROR_CITY_NOT_FOUND);
			}
        }catch(DaoException de) {
            log.error("Exception occured while fetching all cities record in db " + LogConstantUtil.LOG_DAO_EXCEPTION, de);
            return handle602DatabaseError(ConstantUtil.ERROR_CITY_FETCH, de);
        }catch(Exception ex) {
            log.error("Error occured while fetching cities from database",ex);
            return handle500InternalServerError(ConstantUtil.ERROR_CITY_FETCH,ex);
        }
        return handle200OkRequest(cities);
    }
    
}
