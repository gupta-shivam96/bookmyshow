package com.webapp.bookmyshowapp.exceptions;

public class MovieShowException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1984444137277332067L;
	

	public MovieShowException() {

    }

    public MovieShowException(String message) {
        super(message);
    }

    public  MovieShowException(Throwable arg0) {
        super(arg0);
    }

    public MovieShowException(String argo, Throwable arg1) {
        super(argo,arg1);
    }

    public  MovieShowException(String argo, Throwable arg1, boolean arg2, boolean arg3) {
        super(argo,arg1,arg2,arg3);
    }

}
