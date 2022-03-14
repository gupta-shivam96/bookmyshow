package com.webapp.bookmyshowapp.exceptions;

public class ShowException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6067779288617894608L;

	public ShowException() {
		
	}
	
	public ShowException(String message) {
		super(message);
	}
	
	public ShowException(Throwable arg0) {
		super(arg0);
	}
	
	public ShowException(String argo, Throwable arg1) {
		super(argo,arg1);
	}
	
	public ShowException(String argo, Throwable arg1, boolean arg2, boolean arg3) {
		super(argo,arg1,arg2,arg3);
	}

}
