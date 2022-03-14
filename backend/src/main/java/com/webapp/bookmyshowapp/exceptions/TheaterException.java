package com.webapp.bookmyshowapp.exceptions;

public class TheaterException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5475932551802827377L;

	public TheaterException() {

    }

    public TheaterException(String message) {
        super(message);
    }

    public  TheaterException(Throwable arg0) {
        super(arg0);
    }

    public TheaterException(String argo, Throwable arg1) {
        super(argo,arg1);
    }

    public  TheaterException(String argo, Throwable arg1, boolean arg2, boolean arg3) {
        super(argo,arg1,arg2,arg3);
    }
}
