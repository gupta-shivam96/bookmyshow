package com.webapp.bookmyshowapp.bean;

import com.webapp.bookmyshowapp.model.SeatDetail;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ShowAvailiabilityBean {
	
	private Integer maxSeat;
	
	private SeatDetail seatDetails;
	
	public ShowAvailiabilityBean(SeatDetail seatDetails,Integer maxSeat) {
		this.seatDetails = seatDetails;
		this.maxSeat = maxSeat;	
	}
	
	
	public ShowAvailiabilityBean() {}
}
