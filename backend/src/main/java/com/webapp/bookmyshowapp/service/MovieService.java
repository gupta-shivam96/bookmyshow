package com.webapp.bookmyshowapp.service;

import java.util.Set;

import com.webapp.bookmyshowapp.form.MovieCreateForm;
import com.webapp.bookmyshowapp.model.Movie;

public interface MovieService {

	Movie getMovie(String movieName);

	Movie saveMovie(MovieCreateForm movieCreateForm) throws Exception;
	
	Set<Movie> findAllMoviesByNames(Set<String> movieNames);
}
