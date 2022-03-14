package com.webapp.bookmyshowapp.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.bookmyshowapp.bean.ShowAvailiabilityBean;
import com.webapp.bookmyshowapp.model.Ticket;

@Repository
@Transactional(readOnly=true)
public interface TicketRepository extends JpaRepository<Ticket,Long>{

	Ticket findById(long id);
	
	@Query("Select new com.webapp.bookmyshowapp.bean.ShowAvailiabilityBean(t.seatDetail,t.theater.maxSeat) FROM Ticket t where t.theater.name = :theaterName and t.movie.name = :movieName and t.showDate = :showDate and t.show.showTime = :showTime")
	List<ShowAvailiabilityBean> getShowAvailibility(@Param("theaterName") String theaterName,@Param("movieName") String movieName,@Param("showDate") LocalDate showDate,@Param("showTime") LocalTime showTime);

	
}
