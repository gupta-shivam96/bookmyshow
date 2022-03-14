package com.webapp.bookmyshowapp.form;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityMovieCreateForm {
	
	@NotNull(message="city name  should not be blank.")
	private String cityName;
	
	@NotNull(message="movie name  should not be blank.")
	private String movieName;
	
}
