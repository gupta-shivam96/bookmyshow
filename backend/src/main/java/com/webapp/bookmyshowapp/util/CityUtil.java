package com.webapp.bookmyshowapp.util;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webapp.bookmyshowapp.exceptions.CityException;
import com.webapp.bookmyshowapp.form.CityCreateForm;
import com.webapp.bookmyshowapp.model.City;
import com.webapp.bookmyshowapp.validations.CityValidation;

@Component
public class CityUtil extends DateUtil{
	
    Logger log = LoggerFactory.getLogger(CityUtil.class);
    
    @Autowired
    CityValidation cityValidation;

    /*
     * validate Movie
     *
     * @param movie
     * @param validationErrorList
     * @return
     *
     */

    public List<String> validate(CityCreateForm cityCreateForm, List<String> validationErrorList) throws CityException {
        try {
            return cityValidation.validate(cityCreateForm, validationErrorList);
        }catch(Exception e) {
            throw new CityException(e.getMessage());
        }
    }

    /*
     *
     */

    public City createCity(CityCreateForm cityCreateForm) throws Exception{
        log.info("Setting Values for City from CityCreateForm");
        City city = new City();
        try {
            city.setName(cityCreateForm.getName());
            city.setCreated(getCurrentDateAndTime());
        }catch(Exception ex) {
            throw ex;
        }
        log.info("value setting in city completed");
        return  city;
    }
}
