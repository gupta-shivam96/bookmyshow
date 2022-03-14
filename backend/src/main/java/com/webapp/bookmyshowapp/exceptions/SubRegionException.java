package com.webapp.bookmyshowapp.exceptions;

public class SubRegionException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 109607445004233673L;

	public SubRegionException() {
		
	}
	
	public SubRegionException(String message) {
		super(message);
	}
	
	public SubRegionException(Throwable arg0) {
		super(arg0);
	}
	
	public SubRegionException(String argo, Throwable arg1) {
		super(argo,arg1);
	}
	
	public SubRegionException(String argo, Throwable arg1, boolean arg2, boolean arg3) {
		super(argo,arg1,arg2,arg3);
	}
}
