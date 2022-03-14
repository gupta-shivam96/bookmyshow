package com.webapp.bookmyshowapp.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="show")
@Getter@Setter
public class Show implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8600381496084646826L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern = "HH:mm")
	private LocalTime showTime;
	
	@OneToMany(
	mappedBy = "show",
	cascade = CascadeType.ALL)
	@JsonIgnore
	private List<MovieShow> theaterShows = new ArrayList<>();

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "show", cascade = CascadeType.ALL)
	private List<Ticket> tickets = new ArrayList<>();

}
