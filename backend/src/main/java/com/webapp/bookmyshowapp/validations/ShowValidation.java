package com.webapp.bookmyshowapp.validations;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.webapp.bookmyshowapp.exceptions.MovieException;
import com.webapp.bookmyshowapp.exceptions.ShowException;
import com.webapp.bookmyshowapp.form.ShowCreateForm;
import com.webapp.bookmyshowapp.messages.CommonErrorMessageConstant;

@Component
public class ShowValidation {

	Logger log = LoggerFactory.getLogger(ShowValidation.class);
	
	@Autowired
	private CommonErrorMessageConstant commonErrorMessageConstant;
	
	
	/*
	 * validate show
	 * @param entity
	 * 
	 */
	
	public List<String> validate(ShowCreateForm showCreateForm, List<String> validationErrorList) throws ShowException{
		try {
			if(StringUtils.isEmpty(showCreateForm.getHour()) || Objects.isNull(showCreateForm.getHour())) {
				validationErrorList.add("Hour" + commonErrorMessageConstant.getBlankError());
			}
			if(StringUtils.isEmpty(showCreateForm.getMinute()) || Objects.isNull(showCreateForm.getMinute())) {
				validationErrorList.add("Minute" + commonErrorMessageConstant.getBlankError());
			}
		}catch(Exception e) {
			throw new MovieException(e.getMessage());
		}
		return validationErrorList;
	}


}
