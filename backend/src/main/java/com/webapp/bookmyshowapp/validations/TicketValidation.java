package com.webapp.bookmyshowapp.validations;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webapp.bookmyshowapp.exceptions.TicketException;
import com.webapp.bookmyshowapp.form.TicketCreateForm;
import com.webapp.bookmyshowapp.messages.CommonErrorMessageConstant;

@Component
public class TicketValidation {

	Logger log = LoggerFactory.getLogger(TicketValidation.class);

	@Autowired
	private CommonErrorMessageConstant commonErrorMessageConstant;

	/*
     * validate ticket
     * @param entity
     *
     */
    public List<String> validate(TicketCreateForm ticketCreateForm, List<String> validationErrorList) throws TicketException {
        try {
        	if(Objects.isNull(ticketCreateForm.getTheaterName())) {
            	validationErrorList.add("Theater " + commonErrorMessageConstant.getEmptyError());
            }
            if(Objects.isNull(ticketCreateForm.getMovieName())) {
            	validationErrorList.add("Movie " + commonErrorMessageConstant.getEmptyError());
            }
            if(Objects.isNull(ticketCreateForm.getHour())) {
            	validationErrorList.add("Hour Detail" + commonErrorMessageConstant.getEmptyError());
            }
            if(Objects.isNull(ticketCreateForm.getMinute())) {
            	validationErrorList.add("Minute Detail" + commonErrorMessageConstant.getEmptyError());
            }
            if(Objects.isNull(ticketCreateForm.getDate())) {
            	validationErrorList.add("Date " + commonErrorMessageConstant.getEmptyError());
            }
            if(Objects.isNull(ticketCreateForm.getMonth())) {
            	validationErrorList.add("Month " + commonErrorMessageConstant.getEmptyError());
            }
            if(Objects.isNull(ticketCreateForm.getYear())) {
            	validationErrorList.add("Year " + commonErrorMessageConstant.getEmptyError());
            }
            if(Objects.isNull(ticketCreateForm.getPremiumBookedSeats()) && Objects.isNull(ticketCreateForm.getClassicBookedSeats())) {
            	validationErrorList.add("ClassicBookedSeats & PremiumBookedSeats" + commonErrorMessageConstant.getEmptyError());
            }
        }catch(Exception e) {
            throw new TicketException(e.getMessage());
        }
        return validationErrorList;
    }
}
