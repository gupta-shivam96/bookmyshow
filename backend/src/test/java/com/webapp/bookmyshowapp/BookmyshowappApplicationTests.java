package com.webapp.bookmyshowapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.webapp.bookmyshowapp.model.City;
import com.webapp.bookmyshowapp.repository.CityRepository;
import com.webapp.bookmyshowapp.serviceimpl.CityServiceImpl;
import com.webapp.bookmyshowapp.util.DateUtil;

@SpringBootTest
class BookmyshowappApplicationTests {

	@Autowired
	CityServiceImpl cityServiceImpl;
	
	@MockBean
	CityRepository cityRepository;
    
	
	@Test
	public void getAllCities(){
		List<City> cityList = new ArrayList<City>();
		City city1 = new City(1L,"Mumbai",DateUtil.getCurrentDateAndTime());
		City city2 = new City(1L,"Pune",DateUtil.getCurrentDateAndTime());
		cityList.add(city1);
		cityList.add(city2);

		
		Mockito.when(cityRepository.findAll()).thenReturn(cityList);
		
		assertEquals(2,cityServiceImpl.getAllCities().size());

	}
}
