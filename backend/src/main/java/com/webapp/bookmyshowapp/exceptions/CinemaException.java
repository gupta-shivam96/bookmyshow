package com.webapp.bookmyshowapp.exceptions;

public class CinemaException extends RuntimeException{
	
	 	/**
	 * 
	 */
	private static final long serialVersionUID = -696502323251097624L;

		public CinemaException() {

	    }

	    public CinemaException(String message) {
	        super(message);
	    }

	    public  CinemaException(Throwable arg0) {
	        super(arg0);
	    }

	    public CinemaException(String argo, Throwable arg1) {
	        super(argo,arg1);
	    }

	    public  CinemaException(String argo, Throwable arg1, boolean arg2, boolean arg3) {
	        super(argo,arg1,arg2,arg3);
	    }

}
