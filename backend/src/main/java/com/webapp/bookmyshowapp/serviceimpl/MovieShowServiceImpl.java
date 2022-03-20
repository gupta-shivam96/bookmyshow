package com.webapp.bookmyshowapp.serviceimpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.bookmyshowapp.form.MovieShowCreateForm;
import com.webapp.bookmyshowapp.model.MovieShow;
import com.webapp.bookmyshowapp.model.Show;
import com.webapp.bookmyshowapp.repository.MovieShowRepository;
import com.webapp.bookmyshowapp.service.MovieShowService;
import com.webapp.bookmyshowapp.util.MovieShowUtil;

@Service
public class MovieShowServiceImpl implements MovieShowService{

	Logger log = LoggerFactory.getLogger(MovieShowServiceImpl.class);
	
	@Autowired
	MovieShowUtil movieShowUtil;
	
	@Autowired
	MovieShowRepository movieShowRepository;
	
	@Override
	@Transactional
	public MovieShow createMovieShow(MovieShowCreateForm movieShowCreateForm) throws Exception {
		// TODO Auto-generated method stub
		MovieShow movieShow = null;
		try {
			movieShow = movieShowUtil.createMovieShow(movieShowCreateForm);
			log.info("Persisting movieShow record in db");
			movieShow=movieShowRepository.save(movieShow);
			log.info("Persisted movieShow record in db successfully with id : " + movieShow.getId());
		}catch(Exception ex) {
			throw ex;
		}
		return movieShow;
	}

	@Override
	public Set<Show> getShowsByMovie(String movieName, String showDate) {
		// TODO Auto-generated method stub
		Set<Show> shows=null;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate convertedShowDate = LocalDate.parse(showDate, formatter);
			LocalDate currentDate = LocalDate.now();
			if(convertedShowDate.getDayOfMonth() > currentDate.getDayOfMonth() && convertedShowDate.getYear() >= currentDate.getYear() 
					&& convertedShowDate.getMonthValue() >= currentDate.getMonthValue()) {
				log.info("Getting all the shows of movies for next days");
				shows = movieShowRepository.getAllShowsByMovie(movieName);
			}else {
				log.info("Getting all the shows of movies for same day");
				LocalTime currentTime = LocalTime.now();
				shows = movieShowRepository.getAllShowsByMovie(movieName,currentTime);
			}
			
		}catch(Exception ex) {
			throw ex;
		}
		return shows;
	}


}
