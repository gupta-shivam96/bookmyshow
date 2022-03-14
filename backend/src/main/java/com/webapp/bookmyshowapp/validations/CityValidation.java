package com.webapp.bookmyshowapp.validations;

import com.webapp.bookmyshowapp.exceptions.CityException;
import com.webapp.bookmyshowapp.form.CityCreateForm;
import com.webapp.bookmyshowapp.messages.CommonErrorMessageConstant;
import com.webapp.bookmyshowapp.util.CityUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Component
public class CityValidation {
    
	Logger log = LoggerFactory.getLogger(CityValidation.class);

    @Autowired
    private CommonErrorMessageConstant commonErrorMessageConstant;

    /*
     * validate city
     * @param entity
     *
     */
    public List<String> validate(CityCreateForm cityCreateForm, List<String> validationErrorList) throws CityException {
        try {
            if(StringUtils.isEmpty(cityCreateForm.getName())) {
                validationErrorList.add("Name" + commonErrorMessageConstant.getBlankError());
            }
        }catch(Exception e) {
            throw new CityException(e.getMessage());
        }
        return validationErrorList;
    }



}
