package com.webapp.bookmyshowapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.bookmyshowapp.constant.ConstantUtil;
import com.webapp.bookmyshowapp.constant.RestEndPoints;
import com.webapp.bookmyshowapp.exceptions.CastException;
import com.webapp.bookmyshowapp.exceptions.DaoException;
import com.webapp.bookmyshowapp.form.CastCreateForm;
import com.webapp.bookmyshowapp.model.Casting;
import com.webapp.bookmyshowapp.service.CastService;
import com.webapp.bookmyshowapp.util.BaseExceptionHandler;
import com.webapp.bookmyshowapp.util.CastUtil;
import com.webapp.bookmyshowapp.util.LogConstantUtil;

@RestController
@RequestMapping(RestEndPoints.PARENTAPI)
public class CastController extends BaseExceptionHandler {
    Logger log = LoggerFactory.getLogger(CastController.class);

    @Autowired
    CastUtil castUtil;

    @Autowired
    CastService castService;

    
    @DeleteMapping(RestEndPoints.DELETE_CAST)
    public ResponseEntity<Object> deleteCasting(@PathVariable("id") long id){
        try {
            castService.deleteById(id);
        }catch(DaoException de) {
            log.error("Exception occured while deleting casting record in db " +LogConstantUtil.LOG_DAO_EXCEPTION, de);
            return handle602DatabaseError(ConstantUtil.ERROR_CAST_DELETE_DB,de);
        }catch(Exception ex) {
            log.error("Exception Occured While deleting casting record " + LogConstantUtil.LOG_DBDOWN_AND_OTHER_EXCEPTION, ex);
            return handle500InternalServerError(ConstantUtil.ERROR_CAST_DELETE_DB,ex);
        }
        return handle200OkRequest(true);
    }


    @GetMapping(RestEndPoints.GET_CAST)
    public ResponseEntity<Object> getCasting(@PathVariable("id") long id){
       Casting casting = null;
        try {
            casting = castService.getCast(id);
        }catch(DaoException de) {
            log.error("Exception occured while fetching single cast record in db " + LogConstantUtil.LOG_DAO_EXCEPTION, de);
            return handle602DatabaseError(ConstantUtil.ERROR_CAST_FETCH, de);
        }catch(Exception ex) {
            log.error("Error occured while fetching casting from database",ex);
            return handle500InternalServerError(ConstantUtil.ERROR_CAST_FETCH,ex);
        }
        return handle200OkRequest(casting);
    }
    
    @PostMapping(RestEndPoints.CREATE_CAST)
    public ResponseEntity<Object> createCast(@RequestBody CastCreateForm castCreateForm){
        List<String> validationErrorList = new ArrayList<String>();
        Casting casting = null;
        try {
            log.info("Validating CastCreateForm");
            validationErrorList = castUtil.validate(castCreateForm, validationErrorList);
            log.info("Cast Create Form Validation Completed");
            if(!validationErrorList.isEmpty()) {
                log.error(" Error occuured while validating castCreateForm || " + LogConstantUtil.LOG_VALIDATION_ERRORLIST, validationErrorList);
                return handle400BadRequest(validationErrorList);
            }
            casting =castService.saveCast(castCreateForm);
        }catch(CastException ce) {
            log.error("Exception occured while validating cast Create Form in castUtil " +LogConstantUtil.LOG_CAST_EXCEPTION,ce);
            return handle400BadRequest(ConstantUtil.ERROR_CAST_CREATE,ce);
        }catch(DaoException de) {
            log.error("Exception occured while creating cast record in db " +LogConstantUtil.LOG_DAO_EXCEPTION, de);
            return handle602DatabaseError(ConstantUtil.ERROR_CAST_CREATE,de);
        }catch(Exception ex) {
            log.error("Exception occured While creating CAST record " + LogConstantUtil.LOG_DBDOWN_AND_OTHER_EXCEPTION, ex);
            return handle500InternalServerError(ConstantUtil.ERROR_CAST_CREATE,ex);
        }
        return handle200OkRequest(casting);
    }
    
}

