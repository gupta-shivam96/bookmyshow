package com.webapp.bookmyshowapp.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CastCreateForm {

    @NotNull(message="cast name  should not be blank.")
    private String castName;

    @NotNull(message="cast image  should not be blank.")
    private String castImage;

}
