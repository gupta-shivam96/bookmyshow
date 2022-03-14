package com.webapp.bookmyshowapp.util;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webapp.bookmyshowapp.exceptions.CityException;
import com.webapp.bookmyshowapp.exceptions.TheaterException;
import com.webapp.bookmyshowapp.form.TheaterCreateForm;
import com.webapp.bookmyshowapp.model.SubRegion;
import com.webapp.bookmyshowapp.model.Theater;
import com.webapp.bookmyshowapp.repository.SubRegionRepository;
import com.webapp.bookmyshowapp.validations.TheaterValidation;

@Component
public class TheaterUtil extends DateUtil{
	
	Logger log = LoggerFactory.getLogger(TheaterUtil.class);
	
	@Autowired
	TheaterValidation theaterValidation;
	
	@Autowired
	SubRegionRepository subRegionRepository;
	
	 /*
     * validate theater
     *
     * @param theater
     * @param validationErrorList
     * @return
     *
     */

    public List<String> validate(TheaterCreateForm theaterCreateForm, List<String> validationErrorList) throws TheaterException {
        try {
            return theaterValidation.validate(theaterCreateForm, validationErrorList);
        }catch(Exception e) {
            throw new TheaterException(e.getMessage());
        }
    }
    
    
    /*
     * create theater
     *
     * @param theater
     * @param createTheater
     * @return
     *
     */

    public Theater createTheater(TheaterCreateForm theaterCreateForm) throws Exception{
        log.info("Setting Values for theater from TheaterCreateForm");
        Theater theater = new Theater();
        SubRegion subRegion = null;
        try {
        	subRegion = subRegionRepository.findByRegionName(theaterCreateForm.getSubRegionName());
        	if(Objects.isNull(subRegion)) {
            	throw new CityException("SubRegion Not Found For Name : " + theaterCreateForm.getSubRegionName());
            }
        	theater.setName(theaterCreateForm.getName());
        	theater.setAddress(theaterCreateForm.getAddress());
        	theater.setMaxSeat(theaterCreateForm.getMaxSeat());
        	theater.setSubRegion(subRegion);
        	theater.setModified(getCurrentDateAndTime());
        }catch(Exception ex) {
            throw ex;
        }
        log.info("value setting in subregion completed");
        return theater;
    }
}
