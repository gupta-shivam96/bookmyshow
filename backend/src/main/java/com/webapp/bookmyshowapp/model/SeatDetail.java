package com.webapp.bookmyshowapp.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="seat_detail")
@Getter@Setter
public class SeatDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6839402640968664292L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

	@ElementCollection
    @MapKeyColumn(name="seatType")
    @Column(name="seatNumber")
    @CollectionTable(name="seat_type_number")
    Map<String, String> seatTypeNumber = new HashMap<String, String>(); // maps from attribute name to value
	
	@OneToOne(fetch = FetchType.LAZY,
			cascade =  CascadeType.ALL,
            mappedBy = "seatDetail")
	@JsonIgnore
	private Ticket ticket;
	
}
