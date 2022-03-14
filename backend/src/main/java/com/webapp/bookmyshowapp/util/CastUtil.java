package com.webapp.bookmyshowapp.util;

import com.webapp.bookmyshowapp.exceptions.CastException;
import com.webapp.bookmyshowapp.form.CastCreateForm;
import com.webapp.bookmyshowapp.model.Casting;

import com.webapp.bookmyshowapp.validations.CastValidation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CastUtil extends DateUtil {
	
    Logger log = LoggerFactory.getLogger(CastUtil.class);

    @Autowired
    CastValidation castValidation;

    /*
     * validate Cast
     *
     * @param cast
     * @param validationErrorList
     * @return
     *
     */

    public List<String> validate(CastCreateForm castCreateForm, List<String> validationErrorList) throws CastException {
        try {
            return castValidation.validate(castCreateForm, validationErrorList);
        }catch(Exception e) {
            throw new CastException(e.getMessage());
        }
    }

    /*
     * create Cast
     *
     * @param cast
     * @param createCastForm
     * @return
     *
     */

    public Casting createCast(CastCreateForm castCreateForm) throws Exception{
        log.info("Setting Values for Cast from CastCreateForm");
        Casting casting = new Casting();
        try {
            casting.setCastName(castCreateForm.getCastName());
            casting.setCastImage(castCreateForm.getCastImage());
        }catch(Exception ex) {
            throw ex;
        }
        log.info("value setting in cast completed");
        return casting;
    }
}
