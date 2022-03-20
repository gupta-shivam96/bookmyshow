package com.webapp.bookmyshowapp.service;

import java.util.Set;

import com.webapp.bookmyshowapp.form.MovieShowCreateForm;
import com.webapp.bookmyshowapp.model.MovieShow;
import com.webapp.bookmyshowapp.model.Show;

public interface MovieShowService {

	MovieShow createMovieShow(MovieShowCreateForm movieShowCreateForm) throws Exception;
	
	Set<Show> getShowsByMovie(String movieName, String showDate);
}
