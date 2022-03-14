package com.webapp.bookmyshowapp.form;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheaterMovieCreateForm {
	
	@NotNull(message="theater name  should not be blank.")
	private String theaterName;
	
	@NotNull(message="movie name  should not be blank.")
	private String movieName;

}
