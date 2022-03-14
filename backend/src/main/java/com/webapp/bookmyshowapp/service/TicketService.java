package com.webapp.bookmyshowapp.service;

import com.webapp.bookmyshowapp.bean.ShowAvailiabilityResponseBean;
import com.webapp.bookmyshowapp.form.ShowAvailiabilityFetchForm;
import com.webapp.bookmyshowapp.form.TicketCreateForm;
import com.webapp.bookmyshowapp.model.Ticket;

public interface TicketService {

	Ticket createTicket(TicketCreateForm ticketCreateForm) throws Exception;
	
	Ticket getTicket(long id);
	
	ShowAvailiabilityResponseBean getShowAvailiability(ShowAvailiabilityFetchForm showAvailiabilityFetchForm);
}
