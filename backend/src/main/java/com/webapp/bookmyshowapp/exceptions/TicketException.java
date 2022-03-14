package com.webapp.bookmyshowapp.exceptions;

public class TicketException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 497026667502106070L;
	
	public TicketException() {

    }

    public TicketException(String message) {
        super(message);
    }

    public  TicketException(Throwable arg0) {
        super(arg0);
    }

    public TicketException(String argo, Throwable arg1) {
        super(argo,arg1);
    }

    public  TicketException(String argo, Throwable arg1, boolean arg2, boolean arg3) {
        super(argo,arg1,arg2,arg3);
    }


}
