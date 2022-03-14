package com.webapp.bookmyshowapp.service;

import com.webapp.bookmyshowapp.form.TheaterCreateForm;
import com.webapp.bookmyshowapp.model.Theater;

public interface TheaterService {
	
	Theater createTheater(TheaterCreateForm theaterCreateForm) throws Exception;
}
