package com.webapp.bookmyshowapp.constant;

import org.springframework.stereotype.Component;

@Component
public class ConstantUtil {

	/*
	 * Status Code For Exceptions
	 */
	public static final int STATUS_CODE_DATABASE_ERROR  = 602;
	public static final int STATUS_CODE_BAD_REQUEST  = 400;
	public static final int STATUS_CODE_INTERNAL_SERVER_ERROR  = 500;
	public static final int STATUS_CODE_RESOURCE_NOT_FOUND  = 404;
	public static final int STATUS_CODE_OK=200;
	
	/*
	 * Movie Error
	 */
	public static final String ERROR_MOVIE_CREATE  = "Error creating movie";
	public static final String ERROR_MOVIE_NOT_FOUND  = "Error movies does not exist";
	public static final String ERROR_MOVIE_FETCH  = "Error fetching MOVIE in db";
	public static final String ERROR_MOVIE_DELETE_DB = "Error deleting movie in db";
	
	/*
	 * City Error
	 */
	public static final String ERROR_CITY_CREATE  = "Error creating city";
	public static final String ERROR_CITY_FETCH  = "Error fetching city in db";
	public static final String ERROR_CITY_NOT_FOUND = "Error city does not exist";

	/*
	 * Cast Error
	 */
	public static final String ERROR_CAST_DELETE_DB = "Error deleting cast in db";
	public static final String ERROR_CAST_CREATE  = "Error creating cast";
	public static final String ERROR_CAST_NOT_FOUND  = "Error cast does not exist";
	public static final String ERROR_CAST_FETCH  = "Error fetching cast in db";
	
	/*
	 * Subregion Error
	 */
	public static final String ERROR_SUBREGION_CREATE  = "Error creating subregion";
	public static final String ERROR_SUBREGION_NOT_FOUND  = "Error subregion does not exist";
	
	
	public static final String ERROR_THEATER_CREATE  = "Error creating theater";
	
	/*
	 * Theater Movie Error
	 */
	public static final String ERROR_THEATER_MOVIE_CREATE = "Error creating theater movie";
	public static final String ERROR_THEATER_NOT_FOUND  = "Error theater does not exist";
	
	public static final String ERROR_SHOW_CREATE  = "Error creating show";
	public static final String ERROR_SHOW_NOT_FOUND  = "Error show does not exist";
	
	public static final String ERROR_MOVIE_SHOW_CREATE = "Error creating movie show";
	public static final String ERROR_TICKET_CREATE  = "Error creating ticket";
	public static final String ERROR_TICKET_NOT_FOUND = "Error ticket does not exist";
	public static final String ERROR_TICKET_FETCH  = "Error fetching ticket in db";
	
	public static final String ERROR_GET_SHOW_AVAILIABILITY = "Error getting show availiability from ticket";
}
