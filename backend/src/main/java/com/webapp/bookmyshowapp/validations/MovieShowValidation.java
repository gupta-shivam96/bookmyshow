package com.webapp.bookmyshowapp.validations;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.webapp.bookmyshowapp.exceptions.MovieShowException;
import com.webapp.bookmyshowapp.exceptions.TheaterMovieException;
import com.webapp.bookmyshowapp.form.MovieShowCreateForm;
import com.webapp.bookmyshowapp.messages.CommonErrorMessageConstant;

@Component
public class MovieShowValidation {

	Logger log = LoggerFactory.getLogger(MovieShowValidation.class);

    @Autowired
    private CommonErrorMessageConstant commonErrorMessageConstant;
    
    /*
     * validate movieshow
     * @param entity
     *
     */

    public List<String> validate(MovieShowCreateForm movieShowCreateForm, List<String> validationErrorList) throws MovieShowException {
        try {
            if(StringUtils.isEmpty(movieShowCreateForm.getMovieId())) {
                validationErrorList.add("Movie Id" + commonErrorMessageConstant.getBlankError());
            }
            if(StringUtils.isEmpty(movieShowCreateForm.getShowId())) {
                validationErrorList.add("Show Id" + commonErrorMessageConstant.getBlankError());
            }
        }catch(Exception e) {
            throw new TheaterMovieException(e.getMessage());
        }
        return validationErrorList;
    }
    
}
