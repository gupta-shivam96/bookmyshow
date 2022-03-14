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
        	if(Objects.isNull(ticketCreateForm.getTheater())) {
            	validationErrorList.add("Theater " + commonErrorMessageConstant.getEmptyError());
            }
            if(Objects.isNull(ticketCreateForm.getMovie())) {
            	validationErrorList.add("Movie " + commonErrorMessageConstant.getEmptyError());
            }
            if(Objects.isNull(ticketCreateForm.getSeatDetail())) {
            	validationErrorList.add("Seat Detail" + commonErrorMessageConstant.getEmptyError());
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
            if(Objects.isNull(ticketCreateForm.getShow())) {
            	validationErrorList.add("Show " + commonErrorMessageConstant.getEmptyError());
            }
            if(Objects.isNull(ticketCreateForm.getPrice())) {
            	validationErrorList.add("Price " + commonErrorMessageConstant.getEmptyError());
            }
        }catch(Exception e) {
            throw new TicketException(e.getMessage());
        }
        return validationErrorList;
    }
}
