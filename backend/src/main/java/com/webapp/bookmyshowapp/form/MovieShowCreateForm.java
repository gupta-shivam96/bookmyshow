package com.webapp.bookmyshowapp.form;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class MovieShowCreateForm {
	
	@NotNull(message="Movie Id  should not be blank.")
	Long movieId;
	
	@NotNull(message="Show Id  should not be blank.")
	Long showId;

}
