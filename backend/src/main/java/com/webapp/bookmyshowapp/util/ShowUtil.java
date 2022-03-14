package com.webapp.bookmyshowapp.util;

import java.time.LocalTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webapp.bookmyshowapp.exceptions.ShowException;
import com.webapp.bookmyshowapp.form.ShowCreateForm;
import com.webapp.bookmyshowapp.model.Show;
import com.webapp.bookmyshowapp.validations.ShowValidation;

@Component
public class ShowUtil extends DateUtil{

	Logger log = LoggerFactory.getLogger(ShowUtil.class);
	
	@Autowired
	ShowValidation showValidation;
	
	/*
	 * validate Show
	 * 
	 * @param show
	 * @param validationErrorList
	 * @return
	 * 
	 */
	
	public List<String> validate(ShowCreateForm showCreateForm, List<String> validationErrorList) throws ShowException{
		try {
			return showValidation.validate(showCreateForm, validationErrorList);
		}catch(Exception e) {
			throw new ShowException(e.getMessage());
		}
	}
	
	/*
	 * create Show
	 * 
	 * @param show
	 * @param createShowForm
	 * @return
	 * 
	 */
	
	public Show createShow(ShowCreateForm showCreateForm) throws Exception{
		log.info("Setting Values for Show from ShowCreateForm");
		Show show = new Show();
		try {
			LocalTime time = LocalTime.of(showCreateForm.getHour(), showCreateForm.getMinute());
			show.setShowTime(time);
		}catch(Exception ex) {
			throw ex;
		}
		log.info("value setting in movie completed");
		return show;
	}

}
