package com.webapp.bookmyshowapp.form;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class SubRegionCreateForm {
	
	 @NotBlank(message="Region Name should not be blank.")
	 private String regionName;
	 
	 @NotBlank(message="City Name should not be blank.")
	 private String cityName;
}
