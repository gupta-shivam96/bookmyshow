package com.webapp.bookmyshowapp.serviceimpl;

import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.bookmyshowapp.exceptions.DaoException;
import com.webapp.bookmyshowapp.form.TheaterCreateForm;
import com.webapp.bookmyshowapp.model.Theater;
import com.webapp.bookmyshowapp.repository.TheaterRepository;
import com.webapp.bookmyshowapp.service.TheaterService;
import com.webapp.bookmyshowapp.util.TheaterUtil;

@Service
public class TheaterServiceImpl implements TheaterService{

	Logger log = LoggerFactory.getLogger(TheaterServiceImpl.class);
	
	@Autowired
	TheaterUtil theaterUtil;
	
	@Autowired
	TheaterRepository theaterRepository;
	
	@Override
	@Transactional
	public Theater createTheater(TheaterCreateForm theaterCreateForm) throws Exception {
		// TODO Auto-generated method stub
		Theater theater = null;
		try {
			theater = theaterUtil.createTheater(theaterCreateForm);
			log.info("Persisting theater record in db");
			theater=theaterRepository.save(theater);
			log.info("Persisted theater record in db successfully with id : " + theater.getId());
		}catch(PersistenceException de) {
			throw new DaoException(de);
		}catch(Exception ex) {
			throw ex;
		}
		return theater;
	}

}
