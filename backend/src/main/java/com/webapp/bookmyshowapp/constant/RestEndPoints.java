package com.webapp.bookmyshowapp.constant;

public class RestEndPoints {
	
	public static final String PARENTAPI = "/api";
	/*
	 * movie
	 */
	public static final String CREATE_MOVIE = "/movie/new";
	public static final String GET_MOVIE = "/movie/{movie_name}";
	public static final String DELETE_MOVIE = "/movie/delete/{id}";
	/*
	* city
	*/
	public static final String CREATE_CITY = "/city/new";
	public static final String GET_CITY_BY_ID = "/city/{id}";
	public static final String GET_ALL_CITY = "/cities";
	public static final String DELETE_CITY = "/city/delete/{id}";
	
	/*
	 * Theater Movie
	 */
	public static final String CREATE_THEATER_MOVIE = "/theatermovie/new";
	public static final String CREATE_MOVIE_SHOW = "/movieshow/new";
	
	public static final String GET_MOVEIS_BY_CITY = "/movies/{city_name}";
	public static final String GET_THEATERS_BY_CITY_MOVIE = "/theaters/{city_name}/{movie_name}";
	public static final String GET_THEATERS_BY_CITY_REGION_MOVIE = "/theaters/{city_name}/{region_name}/{movie_name}";
	/*
	 * casting
	 */
	public static final String CREATE_CAST = "/casting/new";
	public static final String GET_CAST = "/casting/{id}";
	public static final String DELETE_CAST = "/casting/delete/{id}";
	/*
	 *
	 */
	public static final String CREATE_SECTION = "/section/new";
	public static final String GET_SECTIONS = "/sections";

	public static final String DELETE_SECTION = "/section/delete/{id}";
	public static final String CREATE_CLASS = "/class/new";
	public static final String GET_CLASSES = "/classes";
	public static final String GET_CLASS = "/class/{id}";
	public static final String DELETE_CLASS = "/class/delete/{id}";
	
	public static final String CREATE_STATE = "/state/new";
	public static final String GET_STATES = "/states";
	public static final String GET_STATE = "/state/{id}";
	public static final String DELETE_STATE = "/state/delete/{id}";
	
	public static final String CREATE_SUBREGION = "/subregion/new";
	
	public static final String CREATE_THEATER = "/theater/new";
	
	public static final String CREATE_SHOW = "/show/new";
	
	public static final String GET_SHOWS_BY_MOVIE = "/shows/{movie_name}/{show_date}";
	
	public static final String CREATE_TICKET = "/ticket/new";
	public static final String GET_TICKET = "/ticket/{id}";
	
	public static final String POST_SHOW_AVAILIBILITY = "/query/showavailability";
}
