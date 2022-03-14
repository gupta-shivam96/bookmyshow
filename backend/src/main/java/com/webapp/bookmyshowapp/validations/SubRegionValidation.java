package com.webapp.bookmyshowapp.validations;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.webapp.bookmyshowapp.exceptions.SubRegionException;
import com.webapp.bookmyshowapp.form.SubRegionCreateForm;
import com.webapp.bookmyshowapp.messages.CommonErrorMessageConstant;

@Component
public class SubRegionValidation {
	
	Logger log = LoggerFactory.getLogger(SubRegionValidation.class);
	
	@Autowired
    private CommonErrorMessageConstant commonErrorMessageConstant;
	
	 /*
     * validate cast
     * @param entity
     *
     */

    public List<String> validate(SubRegionCreateForm subRegionCreateForm, List<String> validationErrorList) throws SubRegionException {
        try {
            if(StringUtils.isEmpty(subRegionCreateForm.getRegionName())) {
                validationErrorList.add("Region Name" + commonErrorMessageConstant.getBlankError());
            }
            if(StringUtils.isEmpty(subRegionCreateForm.getCityName())) {
                validationErrorList.add("City Name" + commonErrorMessageConstant.getBlankError());
            }
        }catch(Exception e) {
            throw new SubRegionException(e.getMessage());
        }
        return validationErrorList;
    }
}
