package com.webapp.bookmyshowapp.service;

import java.util.Set;

import com.webapp.bookmyshowapp.form.CastCreateForm;
import com.webapp.bookmyshowapp.model.Casting;


public interface CastService {
	
    Casting getCast(long id);

    Casting saveCast(CastCreateForm castCreateForm) throws Exception;

    void deleteById(long id);
    
    Set<Casting> findAllCastingByNames(Set<String> castNames);
}
