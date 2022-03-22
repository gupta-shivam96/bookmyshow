package com.webapp.bookmyshowapp;

import java.util.ArrayList;
import java.util.List;


import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.webapp.bookmyshowapp.model.City;
import com.webapp.bookmyshowapp.repository.CityRepository;
import com.webapp.bookmyshowapp.serviceimpl.CityServiceImpl;
import com.webapp.bookmyshowapp.util.DateUtil;

@SpringBootTest

class BookmyshowappApplicationTests {

	/*@Test
    void contextLoads() {
    }*/

	 
	@Autowired
	CityServiceImpl cityServiceImpl;
	
	@MockBean
	CityRepository cityRepository;
    
	
	@Test
	public void getAllCities(){
		List<City> cityList = new ArrayList<City>();
		City city1 = new City();
		city1.setId(1L);
		city1.setCreated(DateUtil.getCurrentDateAndTime());
		city1.setName("Mumbai");
		
		City city2 = new City();
		city2.setId(2L);
		city2.setCreated(DateUtil.getCurrentDateAndTime());
		city2.setName("Pune");
		
		cityList.add(city1);
		cityList.add(city2);

		
		Mockito.when(cityRepository.findAll()).thenReturn(cityList);
		
	//	Assert.assertEquals(2,cityServiceImpl.getAllCities().size());

	}

}
