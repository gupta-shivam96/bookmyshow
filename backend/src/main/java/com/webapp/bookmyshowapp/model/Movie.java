package com.webapp.bookmyshowapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.webapp.bookmyshowapp.enums.CertificateType;
import com.webapp.bookmyshowapp.enums.Genre;
import com.webapp.bookmyshowapp.enums.MovieLanguage;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="movie")
@Getter@Setter
public class Movie implements Serializable{

	private static final long serialVersionUID = 7801948490902941821L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String name;
	
	private Date created;
	
	private Date modified;
	
	private String screenType;
	
	@Enumerated(EnumType.STRING)
	private MovieLanguage language;
	
	private String duration;
	
	private Date releaseDate;
	
	@Enumerated(EnumType.STRING)
	private Genre genre;
	
	@Enumerated(EnumType.STRING)
	private CertificateType certifcateType;
	
	private Integer rating;
	
	@OneToMany(
	mappedBy = "movie",
	cascade = CascadeType.ALL)
	@JsonIgnore
	private List<TheaterMovie> theaterMovies = new ArrayList<>();
	
	@OneToMany(
	mappedBy = "movie",
	cascade = CascadeType.ALL)
	@JsonIgnore
	private List<MovieShow> movieShows = new ArrayList<>();

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "movie", cascade = CascadeType.ALL)
	private List<Ticket> tickets = new ArrayList<>();


}
