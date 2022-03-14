package com.webapp.bookmyshowapp.exceptions;

public class MovieException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3507393321747170761L;
	
	public MovieException() {
		
	}
	
	public MovieException(String message) {
		super(message);
	}
	
	public MovieException(Throwable arg0) {
		super(arg0);
	}
	
	public MovieException(String argo, Throwable arg1) {
		super(argo,arg1);
	}
	
	public MovieException(String argo, Throwable arg1, boolean arg2, boolean arg3) {
		super(argo,arg1,arg2,arg3);
	}
}
