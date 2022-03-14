package com.webapp.bookmyshowapp.form;

import java.util.Map;

import javax.validation.constraints.NotNull;

import com.webapp.bookmyshowapp.model.Movie;
import com.webapp.bookmyshowapp.model.Show;
import com.webapp.bookmyshowapp.model.Theater;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class TicketCreateForm {
	
	@NotNull(message="Theater should not be null.")
	private Theater theater;
	
	@NotNull(message="Movie should not be null.")
    private Movie movie;

	@NotNull(message="Show should not be null.")
	private Show show;
	
	@NotNull(message="Movie should not be null.")
	private Map<String,String> seatDetail;
	
	/*@NotNull(message="Time should not be null.")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime showTime;
    
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate showDate;*/
	
	@NotNull(message="Date should not be null.")
	private Integer date;
	
	@NotNull(message="Month should not be null.")
	private Integer month;
	
	@NotNull(message="Year should not be null.")
	private Integer year;

	@NotNull(message="Price should not be null.")
    private Double price;
    
}
