package com.webapp.bookmyshowapp.validations;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.webapp.bookmyshowapp.exceptions.CastException;
import com.webapp.bookmyshowapp.form.CastCreateForm;
import com.webapp.bookmyshowapp.messages.CommonErrorMessageConstant;

@Component
public class CastValidation {
    Logger log = LoggerFactory.getLogger(CastValidation.class);

    @Autowired
    private CommonErrorMessageConstant commonErrorMessageConstant;

    /*
     * validate cast
     * @param entity
     *
     */

    public List<String> validate(CastCreateForm castCreateForm, List<String> validationErrorList) throws CastException {
        try {
            if(StringUtils.isEmpty(castCreateForm.getCastName())) {
                validationErrorList.add("Cast Name" + commonErrorMessageConstant.getBlankError());
            }
            if(StringUtils.isEmpty(castCreateForm.getCastImage())) {
                validationErrorList.add("Cast Image" + commonErrorMessageConstant.getBlankError());
            }
        }catch(Exception e) {
            throw new CastException(e.getMessage());
        }
        return validationErrorList;
    }
}
