package com.webapp.bookmyshowapp.validations;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.webapp.bookmyshowapp.exceptions.CastException;
import com.webapp.bookmyshowapp.exceptions.TheaterMovieException;
import com.webapp.bookmyshowapp.form.TheaterMovieCreateForm;
import com.webapp.bookmyshowapp.messages.CommonErrorMessageConstant;

@Component
public class TheaterMovieValidation {

	
	Logger log = LoggerFactory.getLogger(TheaterMovieValidation.class);

    @Autowired
    private CommonErrorMessageConstant commonErrorMessageConstant;
    

    /*
     * validate theaterMovie
     * @param entity
     *
     */

    public List<String> validate(TheaterMovieCreateForm theaterMovieCreateForm, List<String> validationErrorList) throws TheaterMovieException {
        try {
            if(StringUtils.isEmpty(theaterMovieCreateForm.getTheaterName())) {
                validationErrorList.add("Theater Name" + commonErrorMessageConstant.getBlankError());
            }
            if(StringUtils.isEmpty(theaterMovieCreateForm.getMovieName())) {
                validationErrorList.add("Movie Name" + commonErrorMessageConstant.getBlankError());
            }
        }catch(Exception e) {
            throw new TheaterMovieException(e.getMessage());
        }
        return validationErrorList;
    }
}
