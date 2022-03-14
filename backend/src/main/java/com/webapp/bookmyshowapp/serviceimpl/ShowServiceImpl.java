package com.webapp.bookmyshowapp.serviceimpl;

import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.bookmyshowapp.exceptions.DaoException;
import com.webapp.bookmyshowapp.form.ShowCreateForm;
import com.webapp.bookmyshowapp.model.Show;
import com.webapp.bookmyshowapp.repository.ShowRepository;
import com.webapp.bookmyshowapp.service.ShowService;
import com.webapp.bookmyshowapp.util.ShowUtil;

@Service
public class ShowServiceImpl implements ShowService{

    Logger log = LoggerFactory.getLogger(ShowServiceImpl.class);

    @Autowired
    ShowUtil showUtil;
    
    @Autowired
    ShowRepository showRepository;
    
	@Override
	@Transactional
	public Show saveShow(ShowCreateForm showCreateForm) throws Exception {
		// TODO Auto-generated method stub
		 Show show = null;
		 try {
			 show = showUtil.createShow(showCreateForm);
			 log.info("Persisting show record in db");
			 show = showRepository.save(show);
			 log.info("Persisted show record in db successfully with id : " + show.getId());
		 }catch(PersistenceException de) {
			 throw new DaoException(de);
		 }catch(Exception ex) {
			 throw ex;
		 }
		 return show;

		
	}

}
