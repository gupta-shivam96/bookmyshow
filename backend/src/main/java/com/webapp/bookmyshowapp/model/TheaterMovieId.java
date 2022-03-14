package com.webapp.bookmyshowapp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class TheaterMovieId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4450461881036023184L;

	private Long theaterId;
	 
    private Long movieId;

    public TheaterMovieId(Long theaterId,Long movieId) {
    	this.theaterId = theaterId;
    	this.movieId = movieId;
    }
    
    public TheaterMovieId() {}
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        TheaterMovieId that = (TheaterMovieId) o;
        return Objects.equals(theaterId, that.theaterId) &&
               Objects.equals(movieId, that.movieId);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(theaterId, movieId);
    }
}
