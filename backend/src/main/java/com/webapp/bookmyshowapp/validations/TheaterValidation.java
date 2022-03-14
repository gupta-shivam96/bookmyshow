package com.webapp.bookmyshowapp.validations;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.webapp.bookmyshowapp.exceptions.TheaterException;
import com.webapp.bookmyshowapp.form.TheaterCreateForm;
import com.webapp.bookmyshowapp.messages.CommonErrorMessageConstant;

@Component
public class TheaterValidation {
	
	Logger log = LoggerFactory.getLogger(TheaterValidation.class);

	@Autowired
	private CommonErrorMessageConstant commonErrorMessageConstant;
	
	 /*
     * validate theater
     * @param entity
     *
     */
    public List<String> validate(TheaterCreateForm theaterCreateForm, List<String> validationErrorList) throws TheaterException {
        try {
            if(StringUtils.isEmpty(theaterCreateForm.getName())) {
                validationErrorList.add("Name" + commonErrorMessageConstant.getBlankError());
            }
            if(Objects.isNull(theaterCreateForm.getMaxSeat())) {
            	validationErrorList.add("Seat" + commonErrorMessageConstant.getEmptyError());
            }
            if(StringUtils.isEmpty(theaterCreateForm.getAddress())) {
                validationErrorList.add("Address" + commonErrorMessageConstant.getBlankError());
            }
            if(StringUtils.isEmpty(theaterCreateForm.getSubRegionName())) {
                validationErrorList.add("Region" + commonErrorMessageConstant.getBlankError());
            }
        }catch(Exception e) {
            throw new TheaterException(e.getMessage());
        }
        return validationErrorList;
    }
	
}
