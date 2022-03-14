package com.webapp.bookmyshowapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="theater")
@Getter@Setter
public class Theater implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5247301749212615975L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String name;
	
	private Integer maxSeat;
	
	private String address;
	
	private Date created;
	
	private Date modified;
	
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_region_id", referencedColumnName = "id")
    private SubRegion subRegion;
	
	@OneToMany(
	mappedBy = "theater",
	cascade = CascadeType.ALL)
	@JsonIgnore
	private List<TheaterMovie> theaterMovies = new ArrayList<>();

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "theater", cascade = CascadeType.ALL)
	private List<Ticket> tickets = new ArrayList<>();
	
}
