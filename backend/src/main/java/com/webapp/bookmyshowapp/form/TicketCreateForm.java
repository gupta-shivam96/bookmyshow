package com.webapp.bookmyshowapp.form;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class TicketCreateForm {
	
	@NotNull(message="Theater should not be null.")
	private String theaterName;
	
	@NotNull(message="Movie should not be null.")
    private String movieName;

	@NotNull(message="Hour should not be null.")
	private Integer hour;

	@NotNull(message="Minute should not be null.")
	private Integer minute;
	
	@NotNull(message="Movie should not be null.")
	private List<String> classicBookedSeats;

	@NotNull(message="Movie should not be null.")
	private List<String> premiumBookedSeats;
	
	@NotNull(message="Date should not be null.")
	private Integer date;
	
	@NotNull(message="Month should not be null.")
	private Integer month;
	
	@NotNull(message="Year should not be null.")
	private Integer year;
}
