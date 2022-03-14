package com.webapp.bookmyshowapp.exceptions;

public class TheaterMovieException extends RuntimeException{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 175570078495482173L;

	public TheaterMovieException() {

    }

    public TheaterMovieException(String message) {
        super(message);
    }

    public  TheaterMovieException(Throwable arg0) {
        super(arg0);
    }

    public TheaterMovieException(String argo, Throwable arg1) {
        super(argo,arg1);
    }

    public  TheaterMovieException(String argo, Throwable arg1, boolean arg2, boolean arg3) {
        super(argo,arg1,arg2,arg3);
    }


}
