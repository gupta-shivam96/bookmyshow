package com.webapp.bookmyshowapp.bean;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ShowAvailiabilityResponseBean {
	
	private Boolean showAvailable;
	
	Map<String, String> bookedSeatDetails;
}
