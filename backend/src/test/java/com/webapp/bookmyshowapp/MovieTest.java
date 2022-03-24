package com.webapp.bookmyshowapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.webapp.bookmyshowapp.enums.CertificateType;
import com.webapp.bookmyshowapp.enums.Genre;
import com.webapp.bookmyshowapp.enums.MovieLanguage;
import com.webapp.bookmyshowapp.form.MovieCreateForm;
import com.webapp.bookmyshowapp.model.Movie;
import com.webapp.bookmyshowapp.repository.MovieRepository;
import com.webapp.bookmyshowapp.serviceimpl.MovieServiceImpl;
import com.webapp.bookmyshowapp.util.DateUtil;
import com.webapp.bookmyshowapp.util.MovieUtil;

@SpringBootTest
public class MovieTest {
	
	@Autowired
	MovieServiceImpl movieServiceImpl;
	
	@MockBean
	MovieUtil movieUtil;
	
	@MockBean
	MovieRepository movieRepository;
	
	@Test
	public void createMovie() throws Exception {
		MovieCreateForm movieCreateForm = new MovieCreateForm("Gangubai Kathiawadi","2D 3D","HINDI","2h 30min",
				new SimpleDateFormat("dd/MM/yyyy").parse("2/12/2021"),"HORROR","UA","gangubai_front.jpg",
				"gangubai_background.jpg",81);
		
		Movie movie = new Movie(1L,"Gangubai Kathiawadi",DateUtil.getCurrentDateAndTime(),
				"2D 3D",MovieLanguage.valueOf("HINDI"),"2h 30min","gangubai_front.jpg","gangubai_background.jpg",
				new SimpleDateFormat("dd/MM/yyyy").parse("2/12/2021"),Genre.valueOf("HORROR"),CertificateType.valueOf("UA"),
				81);
		
		Mockito.when(movieUtil.createMovie(movieCreateForm)).thenReturn(movie);
		Mockito.when(movieRepository.save(movie)).thenReturn(movie);
		assertEquals(movie,movieServiceImpl.saveMovie(movieCreateForm));
	}
    
}
