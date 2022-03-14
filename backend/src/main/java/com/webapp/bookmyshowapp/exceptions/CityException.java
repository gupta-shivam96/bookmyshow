package com.webapp.bookmyshowapp.exceptions;

public class CityException extends RuntimeException{

	
	/**
     *
     */
	private static final long serialVersionUID = -4828769159869465184L;

    public CityException() {

    }

    public CityException(String message) {
        super(message);
    }

    public  CityException(Throwable arg0) {
        super(arg0);
    }

    public CityException(String argo, Throwable arg1) {
        super(argo,arg1);
    }

    public  CityException(String argo, Throwable arg1, boolean arg2, boolean arg3) {
        super(argo,arg1,arg2,arg3);
    }
}
