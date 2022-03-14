package com.webapp.bookmyshowapp.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class TheaterCreateForm {
	
	@NotBlank(message="Theater Name should not be blank.")
	private String name;
	
	@NotNull(message="Seat should not be null.")
	private Integer maxSeat;
	
	@NotBlank(message="Address should not be blank.")
	private String address;
	
	@NotBlank(message="Sub Region Name should not be blank.")
	private String subRegionName;
}
