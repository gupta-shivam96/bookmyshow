package com.webapp.bookmyshowapp.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class MovieShowId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4345510800712858835L;
	
	private Long movieId;
	 
    private Long showId;
    
    
    public MovieShowId(Long movieId,Long showId) {
    	this.movieId = movieId;
    	this.showId = showId;
    }
    
    public MovieShowId() {}
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        MovieShowId that = (MovieShowId) o;
        return Objects.equals(movieId, that.movieId) &&
               Objects.equals(showId, that.showId);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(movieId, showId);
    }

}
