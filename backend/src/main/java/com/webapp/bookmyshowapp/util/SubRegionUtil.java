package com.webapp.bookmyshowapp.util;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webapp.bookmyshowapp.exceptions.CityException;
import com.webapp.bookmyshowapp.exceptions.SubRegionException;
import com.webapp.bookmyshowapp.form.SubRegionCreateForm;
import com.webapp.bookmyshowapp.model.City;
import com.webapp.bookmyshowapp.model.SubRegion;
import com.webapp.bookmyshowapp.repository.CityRepository;
import com.webapp.bookmyshowapp.validations.SubRegionValidation;

@Component
public class SubRegionUtil extends DateUtil{
	
	Logger log = LoggerFactory.getLogger(SubRegionUtil.class);
	
	@Autowired
	SubRegionValidation subRegionValidation;
	
	@Autowired
	CityRepository cityRepository;
	
	 /*
     * validate subregion
     *
     * @param subregion
     * @param validationErrorList
     * @return
     *
     */

    public List<String> validate(SubRegionCreateForm subRegionCreateForm, List<String> validationErrorList) throws SubRegionException {
        try {
            return subRegionValidation.validate(subRegionCreateForm, validationErrorList);
        }catch(Exception e) {
            throw new SubRegionException(e.getMessage());
        }
    }
    
    /*
     * create subregion
     *
     * @param subregion
     * @param createSubRegion
     * @return
     *
     */

    public SubRegion createSubRegion(SubRegionCreateForm subRegionCreateForm) throws Exception{
        log.info("Setting Values for Cast from SubRegionCreateForm");
        SubRegion subRegion = new SubRegion();
        City city = null;
        try {
        	city = cityRepository.findByName(subRegionCreateForm.getCityName());
        	if(Objects.isNull(city)) {
            	throw new CityException("City Not Found For Name : " + subRegionCreateForm.getCityName());
            }
        	subRegion.setRegionName(subRegionCreateForm.getRegionName());
        	subRegion.setCreated(getCurrentDateAndTime());
        	subRegion.setCity(city);
        }catch(Exception ex) {
            throw ex;
        }
        log.info("value setting in subregion completed");
        return subRegion;
    }
}
