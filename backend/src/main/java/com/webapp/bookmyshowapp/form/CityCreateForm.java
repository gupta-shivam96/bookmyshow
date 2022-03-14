package com.webapp.bookmyshowapp.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
public class CityCreateForm {
	
    @NotBlank(message="Name should not be blank.")
    private String name;

}
