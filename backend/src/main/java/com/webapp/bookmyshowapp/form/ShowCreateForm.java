package com.webapp.bookmyshowapp.form;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class ShowCreateForm {
	
	@NotNull(message="Hour should not be blank.")
	private Integer hour;
	
	@NotNull(message="Minute should not be blank.")
	private Integer minute;

}
