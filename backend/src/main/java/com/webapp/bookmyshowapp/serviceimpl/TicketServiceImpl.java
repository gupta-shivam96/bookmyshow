package com.webapp.bookmyshowapp.serviceimpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.bookmyshowapp.bean.ShowAvailiabilityBean;
import com.webapp.bookmyshowapp.bean.ShowAvailiabilityResponseBean;
import com.webapp.bookmyshowapp.enums.SeatType;
import com.webapp.bookmyshowapp.form.ShowAvailiabilityFetchForm;
import com.webapp.bookmyshowapp.form.TicketCreateForm;
import com.webapp.bookmyshowapp.model.SeatDetail;
import com.webapp.bookmyshowapp.model.Ticket;
import com.webapp.bookmyshowapp.repository.SeatDetailRepository;
import com.webapp.bookmyshowapp.repository.TicketRepository;
import com.webapp.bookmyshowapp.service.TicketService;
import com.webapp.bookmyshowapp.util.TicketUtil;

@Service
public class TicketServiceImpl implements TicketService{

	Logger log = LoggerFactory.getLogger(TicketServiceImpl.class);
	
	@Autowired
	TicketUtil ticketUtil;
	
	@Autowired
	SeatDetailRepository seatDetailRepository;
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Override
	@Transactional
	public Ticket createTicket(TicketCreateForm ticketCreateForm) throws Exception{
		// TODO Auto-generated method stub
		SeatDetail seatDetail = new SeatDetail();
		Ticket ticket = null;
		Integer totalNumberOfPremiumBookedSeats = null;
		Integer totalNumberOfClassicBookedSeats = null;
		try {
			Map<String,String> seatTypeNumberDetails = new HashMap<String,String>();
			if(!ticketCreateForm.getPremiumBookedSeats().isEmpty() && Objects.nonNull(ticketCreateForm.getPremiumBookedSeats())) {
				totalNumberOfPremiumBookedSeats=ticketCreateForm.getPremiumBookedSeats().size();
				String premiumSeats = String.join(",", ticketCreateForm.getPremiumBookedSeats());
				seatTypeNumberDetails.put(SeatType.PREMIUM.toString(), premiumSeats);
			}
			if(!ticketCreateForm.getClassicBookedSeats().isEmpty() && Objects.nonNull(ticketCreateForm.getClassicBookedSeats())) {
				totalNumberOfClassicBookedSeats=ticketCreateForm.getClassicBookedSeats().size();
				String classicSeats = String.join(",", ticketCreateForm.getClassicBookedSeats());
				seatTypeNumberDetails.put(SeatType.CLASSIC.toString(), classicSeats);
			}
			seatDetail.setSeatTypeNumber(seatTypeNumberDetails);
			log.info("Persisting seat detail record in db");
			seatDetail = seatDetailRepository.save(seatDetail);
			log.info("Persisted seat detail record in db successfully with id : " + seatDetail.getId());
			ticket = ticketUtil.createTicket(ticketCreateForm, seatDetail, totalNumberOfPremiumBookedSeats, totalNumberOfClassicBookedSeats);
			log.info("Persisting ticket detail record in db");
			ticket = ticketRepository.save(ticket);
			log.info("Persisted ticket detail record in db successfully with id : " + ticket.getId());
		}catch(Exception ex) {
			throw ex;
		}
		return ticket;
	}

	@Override
	public Ticket getTicket(long id) {
		// TODO Auto-generated method stub
		Ticket ticket = null;
		try {
			log.info("Fetching ticket from database for id : " + id);
			ticket = ticketRepository.findById(id);
			log.info("Ticket fetched succesfully from data base");
		}catch(Exception ex) {
			throw ex;
		}
		return ticket;
	}

	@Override
	public ShowAvailiabilityResponseBean getShowAvailiability(ShowAvailiabilityFetchForm showAvailiabilityFetchForm) {
		// TODO Auto-generated method stub
		List<ShowAvailiabilityBean> showAvailiabilityBean = null;
		ShowAvailiabilityResponseBean showAvailiabilityResponseBean = null;
		try {
			LocalDate showDate = LocalDate.of(showAvailiabilityFetchForm.getYear(), showAvailiabilityFetchForm.getMonth(), showAvailiabilityFetchForm.getDate());
			LocalTime showTime = LocalTime.of(showAvailiabilityFetchForm.getHour(), showAvailiabilityFetchForm.getMinute());
			log.info("Fetchng show availiability from db");
			showAvailiabilityBean = ticketRepository.getShowAvailibility(showAvailiabilityFetchForm.getTheaterName(), showAvailiabilityFetchForm.getMovieName(),showDate, showTime);
			log.info("Show availiability fetched successfully from db");
			if(Objects.nonNull(showAvailiabilityBean)) {
				List<String> premiumBookedSeats = new ArrayList<>();
				List<String> classicBookedSeats = new ArrayList<>();
				int totalBookedSeat=0;
				int maxSeat=0;
				for(ShowAvailiabilityBean showAvaialiability : showAvailiabilityBean) {
					for(Map.Entry<String,String> entry : showAvaialiability.getSeatDetails().getSeatTypeNumber().entrySet()) {
						totalBookedSeat = totalBookedSeat + entry.getValue().split(",").length;
						maxSeat=showAvaialiability.getMaxSeat();
						if(entry.getKey().equals(SeatType.PREMIUM.toString())) {
							Collections.addAll(premiumBookedSeats, entry.getValue().split(","));
						}else if(entry.getKey().equals(SeatType.CLASSIC.toString())) {
							Collections.addAll(classicBookedSeats, entry.getValue().split(","));
						}
					}

				}
				showAvailiabilityResponseBean = new ShowAvailiabilityResponseBean();
				showAvailiabilityResponseBean.setPremiumBookedSeats(premiumBookedSeats);
				showAvailiabilityResponseBean.setClassicBookedSeats(classicBookedSeats);
				if(maxSeat == totalBookedSeat && totalBookedSeat != 0) {
					showAvailiabilityResponseBean.setShowAvailable(false);
				}else {
					showAvailiabilityResponseBean.setShowAvailable(true);
				}
				
			}
		}catch(Exception ex) {
			throw ex;
		}
		return showAvailiabilityResponseBean;
	}

}
