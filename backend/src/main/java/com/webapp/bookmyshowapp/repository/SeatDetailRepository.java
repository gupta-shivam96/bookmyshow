package com.webapp.bookmyshowapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.bookmyshowapp.model.SeatDetail;

@Repository
@Transactional(readOnly=true)
public interface SeatDetailRepository extends JpaRepository<SeatDetail,Long>{

}
