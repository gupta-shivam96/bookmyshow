package com.webapp.bookmyshowapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.bookmyshowapp.constant.ConstantUtil;
import com.webapp.bookmyshowapp.constant.RestEndPoints;
import com.webapp.bookmyshowapp.exceptions.DaoException;
import com.webapp.bookmyshowapp.exceptions.MovieException;
import com.webapp.bookmyshowapp.exceptions.ShowException;
import com.webapp.bookmyshowapp.exceptions.TheaterException;
import com.webapp.bookmyshowapp.exceptions.TicketException;
import com.webapp.bookmyshowapp.form.TicketCreateForm;
import com.webapp.bookmyshowapp.model.Ticket;
import com.webapp.bookmyshowapp.service.TicketService;
import com.webapp.bookmyshowapp.util.BaseExceptionHandler;
import com.webapp.bookmyshowapp.util.LogConstantUtil;
import com.webapp.bookmyshowapp.util.TicketUtil;

@RestController
@RequestMapping(RestEndPoints.PARENTAPI)
public class TicketController extends BaseExceptionHandler{
	
	Logger log = LoggerFactory.getLogger(TicketController.class);
	
    @Autowired
    TicketUtil ticketUtil;

    @Autowired
    TicketService ticketService;
    
    @PostMapping(RestEndPoints.CREATE_TICKET)
    public ResponseEntity<Object> createTicket(@RequestBody TicketCreateForm ticketCreateForm){
        List<String> validationErrorList = new ArrayList<String>();
        Ticket ticket = null;
        try {
        	log.info("Validating TicketCreateForm");
        	validationErrorList = ticketUtil.validate(ticketCreateForm, validationErrorList);
            log.info("Ticket Create Form Validation Completed");
            if(!validationErrorList.isEmpty()) {
                log.error(" Error occuured while validating cityCreateForm || " + LogConstantUtil.LOG_VALIDATION_ERRORLIST, validationErrorList);
                return handle400BadRequest(validationErrorList);
            }
            ticket=ticketService.createTicket(ticketCreateForm);
            
        }catch(TicketException te) {
            log.error("Exception occured while validating ticket Create Form in cityUtil " +LogConstantUtil.LOG_TICKET_EXCEPTION,te);
            return handle400BadRequest(ConstantUtil.ERROR_TICKET_CREATE,te);
        }catch(MovieException me) {
			log.error("No movie exist for the given name in request" +LogConstantUtil.LOG_MOVIE_EXCEPTION,me);
			return handle404ResourceNotFoundRequest(ConstantUtil.ERROR_MOVIE_NOT_FOUND,me);
	    }catch(TheaterException ce) {
			log.error("No Theater exist for the given name in request" +LogConstantUtil.LOG_THEATER_EXCEPTION,ce);
			return handle404ResourceNotFoundRequest(ConstantUtil.ERROR_THEATER_NOT_FOUND,ce);
	    }catch(ShowException se) {
			log.error("No Show exist for the given show time in request" +LogConstantUtil.LOG_SHOW_EXCEPTION,se);
			return handle404ResourceNotFoundRequest(ConstantUtil.ERROR_SHOW_NOT_FOUND,se);
	    }catch(Exception ex) {
        	log.error("Exception Occured While creating ticket record " + LogConstantUtil.LOG_DBDOWN_AND_OTHER_EXCEPTION, ex);
			return handle500InternalServerError(ConstantUtil.ERROR_TICKET_CREATE,ex);
        }
        return handle200OkRequest(ticket);
    }
    
    @GetMapping(RestEndPoints.GET_TICKET)
    public ResponseEntity<Object> getTicket(@PathVariable("id") long id){
        Ticket ticket = null;
    	try {
            ticket = ticketService.getTicket(id);
            if(Objects.isNull(ticket)) {
				return handle404ResourceNotFoundRequest(ConstantUtil.ERROR_TICKET_NOT_FOUND);
			}
        }catch(DaoException de) {
            log.error("Exception occured while fetching single ticket record in db " + LogConstantUtil.LOG_DAO_EXCEPTION, de);
            return handle602DatabaseError(ConstantUtil.ERROR_TICKET_FETCH, de);
        }catch(Exception ex) {
            log.error("Error occured while fetching ticket from database",ex);
            return handle500InternalServerError(ConstantUtil.ERROR_TICKET_FETCH,ex);
        }
        return handle200OkRequest(ticket);

    }
    
}
