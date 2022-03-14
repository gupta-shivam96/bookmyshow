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
@Table(name="movie_show")
@Getter@Setter
public class MovieShow implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1483912279532142840L;
	
	@EmbeddedId
	private MovieShowId id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("movieId")
	private Movie movie;
	 
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("showId")
	private Show show;
	
	public MovieShow(Movie movie, Show show) {
        this.movie = movie;
        this.show = show;
        this.id = new MovieShowId(movie.getId(), show.getId());
    }
	
	public MovieShow() {}
}
