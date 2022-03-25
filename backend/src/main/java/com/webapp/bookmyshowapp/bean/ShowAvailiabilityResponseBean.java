package com.webapp.bookmyshowapp.bean;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ShowAvailiabilityResponseBean {
	
	private Boolean showAvailable;
	
	private List<String> premiumBookedSeats;
	
	private List<String> classicBookedSeats;
}
