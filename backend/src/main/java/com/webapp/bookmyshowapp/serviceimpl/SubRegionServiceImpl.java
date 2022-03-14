package com.webapp.bookmyshowapp.serviceimpl;

import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.bookmyshowapp.exceptions.DaoException;
import com.webapp.bookmyshowapp.form.SubRegionCreateForm;
import com.webapp.bookmyshowapp.model.Movie;
import com.webapp.bookmyshowapp.model.SubRegion;
import com.webapp.bookmyshowapp.repository.SubRegionRepository;
import com.webapp.bookmyshowapp.service.SubRegionService;
import com.webapp.bookmyshowapp.util.SubRegionUtil;

@Service
public class SubRegionServiceImpl implements SubRegionService{
	
	Logger log = LoggerFactory.getLogger(SubRegionServiceImpl.class);
	
	@Autowired
	SubRegionUtil subRegionUtil;
	
	@Autowired
	SubRegionRepository subRegionRepository;
	
	@Override
	@Transactional
	public SubRegion saveSubRegion(SubRegionCreateForm subRegionCreateForm) throws Exception {
		// TODO Auto-generated method stub
		SubRegion subRegion = null;
		try {
			subRegion = subRegionUtil.createSubRegion(subRegionCreateForm);
			log.info("Persisting subregion record in db");
			subRegion = subRegionRepository.save(subRegion);
			log.info("Persisted subregion record in db successfully with id : " + subRegion.getId());
		}catch(PersistenceException de) {
			throw new DaoException(de);
		}catch(Exception ex) {
			throw ex;
		}
		return subRegion;
	}

}
