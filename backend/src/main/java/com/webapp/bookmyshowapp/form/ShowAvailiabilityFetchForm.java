package com.webapp.bookmyshowapp.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ShowAvailiabilityFetchForm {

	/*@NotBlank(message="City name should not be blank.")
	private String cityName;
	
	@NotBlank(message="SubRegion name should not be blank.")
	private String regionName;
	
*/	@NotBlank(message="Theater name should not be blank.")
	private String theaterName;
	
	@NotBlank(message="Movie name should not be blank.")
	private String movieName;
	
	@NotNull(message="Year name should not be null.")
	private Integer year;
	
	@NotNull(message="Month name should not be null.")
	private Integer month;
	
	@NotNull(message="Date name should not be null.")
	private Integer date;
	
	@NotNull(message="Hour name should not be null.")
	private Integer hour;
	
	@NotNull(message="Minute name should not be null.")
	private Integer minute;
}
