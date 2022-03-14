package com.webapp.bookmyshowapp.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="theater_movie")
@Getter@Setter
public class TheaterMovie implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3722049347457951933L;

	@EmbeddedId
	private TheaterMovieId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("theaterId")
	private Theater theater;
	 
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("movieId")
	private Movie movie;
	
	public TheaterMovie(Theater theater, Movie movie) {
        this.theater = theater;
        this.movie = movie;
        this.id = new TheaterMovieId(theater.getId(), movie.getId());
    }
	
	public TheaterMovie() {} 



}
