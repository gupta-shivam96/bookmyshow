package com.webapp.bookmyshowapp.serviceimpl;

import java.util.Set;

import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.bookmyshowapp.exceptions.DaoException;
import com.webapp.bookmyshowapp.form.CastCreateForm;
import com.webapp.bookmyshowapp.model.Casting;
import com.webapp.bookmyshowapp.repository.CastRepository;
import com.webapp.bookmyshowapp.service.CastService;
import com.webapp.bookmyshowapp.util.CastUtil;

@Service
public class CastServiceImpl implements CastService {
	
    Logger log = LoggerFactory.getLogger(CastServiceImpl.class);


    @Autowired
    CastRepository castRepository;
    
    @Autowired
    CastUtil castUtil;

    @Override
    @Transactional
    public Casting saveCast(CastCreateForm castCreateForm) throws Exception {
        // TODO Auto-generated method stub
        Casting  casting = null;
        try {
            casting = castUtil.createCast(castCreateForm);
            log.info("Persisting cast record in db");
            casting = castRepository.save(casting);
            log.info("Persisted cast record in db successfully with id : " + casting.getId());
        }catch(PersistenceException de) {
            throw new DaoException(de);
        }catch(Exception ex) {
            throw ex;
        }
        return casting;
    }

	@Override
	public Casting getCast(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Casting> findAllCastingByNames(Set<String> castNames) {
		// TODO Auto-generated method stub
		Set<Casting> castings=null;
		try {
			log.info("Fetching castings from db for names : " + castNames);
			castings=castRepository.findAllCastingByNames(castNames);
		}catch(PersistenceException de) {
			throw new DaoException(de);
		}catch(Exception ex) {
			throw ex;
		}
		return castings;
	}

}
