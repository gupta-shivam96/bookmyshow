package com.webapp.bookmyshowapp.form;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityCreateForm {
	
    @NotBlank(message="Name should not be blank.")
    private String name;

}
