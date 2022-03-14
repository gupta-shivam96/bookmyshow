package com.webapp.bookmyshowapp.exceptions;

public class CityMovieException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8163084093860930148L;
	
    public CityMovieException() {

    }

    public CityMovieException(String message) {
        super(message);
    }

    public  CityMovieException(Throwable arg0) {
        super(arg0);
    }

    public CityMovieException(String argo, Throwable arg1) {
        super(argo,arg1);
    }

    public  CityMovieException(String argo, Throwable arg1, boolean arg2, boolean arg3) {
        super(argo,arg1,arg2,arg3);
    }
}
