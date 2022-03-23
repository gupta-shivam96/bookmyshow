package com.webapp.bookmyshowapp.serviceimpl;

import java.util.List;

import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webapp.bookmyshowapp.exceptions.DaoException;
import com.webapp.bookmyshowapp.form.CityCreateForm;
import com.webapp.bookmyshowapp.model.City;
import com.webapp.bookmyshowapp.repository.CityRepository;
import com.webapp.bookmyshowapp.service.CityService;
import com.webapp.bookmyshowapp.util.CityUtil;

@Service
public class CityServiceImpl implements CityService {

    Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);
    
    @Autowired
    CityUtil cityUtil;

    @Autowired
    CityRepository cityRepository;

	@Override
	@Transactional
	public City saveCity(CityCreateForm cityCreateForm) throws Exception {
		// TODO Auto-generated method stub
		 City city = null;
		 try {
			 city = cityUtil.createCity(cityCreateForm);
			 log.info("Persisting city record in db");
			 city = cityRepository.save(city);
			 log.info("Persisted city record in db successfully with id : " + city.getId());
		 }catch(PersistenceException de) {
			 throw new DaoException(de);
		 }catch(Exception ex) {
			 throw ex;
		 }
		 return city;
	}

	@Override
	public City getCity(long id) {
		// TODO Auto-generated method stub
		City city = null;
		try {
			log.info("Fetching city from database for id : " + id);
			city = cityRepository.findById(id);
			log.info("City fetched from database successfully for id : " + id);
		}catch(Exception ex) {
			throw ex;
		}
		return city;
	}

	@Override
	public List<City> getAllCities() {
		// TODO Auto-generated method stub
		List<City> cities=null;
		try {
			ObjectMapper obj = new ObjectMapper();
			log.info("Fetching all cities from database");
			cities = cityRepository.findAll();
			log.info("Obtained Cities : " + obj.writeValueAsString(cities));
			log.info("Cities fetched from database successfully");
		}catch(Exception ex) {
			//throw ex;
		}
		return cities;
	}
}
