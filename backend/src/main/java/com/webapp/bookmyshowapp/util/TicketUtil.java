package com.webapp.bookmyshowapp.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webapp.bookmyshowapp.exceptions.MovieException;
import com.webapp.bookmyshowapp.exceptions.ShowException;
import com.webapp.bookmyshowapp.exceptions.TheaterException;
import com.webapp.bookmyshowapp.exceptions.TicketException;
import com.webapp.bookmyshowapp.form.TicketCreateForm;
import com.webapp.bookmyshowapp.model.Movie;
import com.webapp.bookmyshowapp.model.SeatDetail;
import com.webapp.bookmyshowapp.model.Show;
import com.webapp.bookmyshowapp.model.Theater;
import com.webapp.bookmyshowapp.model.Ticket;
import com.webapp.bookmyshowapp.repository.MovieRepository;
import com.webapp.bookmyshowapp.repository.ShowRepository;
import com.webapp.bookmyshowapp.repository.TheaterRepository;
import com.webapp.bookmyshowapp.validations.TicketValidation;

@Component
public class TicketUtil extends DateUtil{

	Logger log = LoggerFactory.getLogger(TicketUtil.class);
	
	@Autowired
	TicketValidation ticketValidation;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	TheaterRepository theaterRepository;
	
	@Autowired
	ShowRepository showRepository;
	
	 /*
     * validate ticket
     *
     * @param ticket
     * @param validationErrorList
     * @return
     *
     */

    public List<String> validate(TicketCreateForm ticketCreateForm, List<String> validationErrorList) throws TicketException {
        try {
            return ticketValidation.validate(ticketCreateForm, validationErrorList);
        }catch(Exception e) {
            throw new TicketException(e.getMessage());
        }
    }

    /*
     * create ticket
     *
     * @param ticket
     * @param createTicket
     * @return
     *
     */

    public Ticket createTicket(TicketCreateForm ticketCreateForm,SeatDetail seatDetail, Integer totalNumberOfPremiumBookedSeats, Integer totalNumberOfClassicBookedSeats) throws Exception{
        log.info("Setting Values for ticket from TheaterCreateForm");
        Ticket ticket = new Ticket();
        try {
        	
        	Movie movie = movieRepository.findByName(ticketCreateForm.getMovieName());
        	if(Objects.isNull(movie)) {
            	throw new MovieException("Movie Not Found For name : " + ticketCreateForm.getMovieName());
            }
        	Theater theater = theaterRepository.findByName(ticketCreateForm.getTheaterName());
        	if(Objects.isNull(theater)) {
            	throw new TheaterException("Theater Not Found For name : " + ticketCreateForm.getTheaterName());
            }
        	Show show = showRepository.findByShowTime(LocalTime.of(ticketCreateForm.getHour(), ticketCreateForm.getMinute()));
        	if(Objects.isNull(show)) {
            	throw new ShowException("Show Not Found For time : " + ticketCreateForm.getHour() + ":" + ticketCreateForm.getMinute());
            }
        	ticket.setMovie(movie);
        	ticket.setTheater(theater);
        	ticket.setSeatDetail(seatDetail);
        	ticket.setShowDate(LocalDate.of(ticketCreateForm.getYear(), ticketCreateForm.getMonth(), ticketCreateForm.getDate()));
        	ticket.setShow(show);
        	ticket.setBookingDate(getCurrentLocalDateTime());
        	
        	/*
        	 * Setting Ticket Price
        	 */
        	if(Objects.nonNull(totalNumberOfPremiumBookedSeats)) {
        		ticket.setPremiumSeatPrice(theater.getPremiumSeatPrice() * totalNumberOfPremiumBookedSeats);
        	}
        	if(Objects.nonNull(totalNumberOfClassicBookedSeats)) {
        		ticket.setClassicSeatPrice(theater.getClassicSeatPrice() * totalNumberOfClassicBookedSeats);
        	}
        }catch(Exception ex) {
            throw ex;
        }
        log.info("value setting in subregion completed");
        return ticket;
    }

}
