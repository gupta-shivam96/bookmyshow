package com.webapp.bookmyshowapp.exceptions;

public class DaoException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DaoException() {
		
	}
	
	/*
	 * @params message
	 */
	public DaoException(String message) {
		super(message);
	}
	
	/*
	 * @params arg0
	 */
	public DaoException(Throwable arg0) {
		super(arg0);
	}
	
	/*
	 * @params arg0
	 * @params arg1
	 */
	public DaoException(String argo, Throwable arg1) {
		super(argo,arg1);
	}
	
	/*
	 * @params arg0
	 * @params arg1
	 * @params arg2
	 * @params arg3
	 */
	public DaoException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		
	}
}
