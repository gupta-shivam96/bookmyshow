package com.webapp.bookmyshowapp.validations;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.webapp.bookmyshowapp.exceptions.MovieException;
import com.webapp.bookmyshowapp.form.MovieCreateForm;
import com.webapp.bookmyshowapp.messages.CommonErrorMessageConstant;
import com.webapp.bookmyshowapp.util.MovieUtil;

@Component
public class MovieValidation {
	
	Logger log = LoggerFactory.getLogger(MovieValidation.class);
	
	@Autowired
	private CommonErrorMessageConstant commonErrorMessageConstant;
	
	/*
	 * validate movie
	 * @param entity
	 * 
	 */
	
	public List<String> validate(MovieCreateForm movieCreateForm, List<String> validationErrorList) throws MovieException{
		try {
			if(StringUtils.isEmpty(movieCreateForm.getName())) {
				validationErrorList.add("Name" + commonErrorMessageConstant.getBlankError());
			}
		}catch(Exception e) {
			throw new MovieException(e.getMessage());
		}
		return validationErrorList;
	}
	
}
