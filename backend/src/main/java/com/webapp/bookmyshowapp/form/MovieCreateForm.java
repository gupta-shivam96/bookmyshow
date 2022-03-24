package com.webapp.bookmyshowapp.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class MovieCreateForm {
	
	public MovieCreateForm() {}
	
	public MovieCreateForm(String name,String screenType,String language,String duration,Date releaseDate,
			String genre,String certificateType,String imageName,String backgroundImageName,Integer rating) {
		this.name = name;
		this.screenType = screenType;
		this.language = language;
		this.duration = duration;
		this.releaseDate = releaseDate;
		this.genre = genre;
		this.certificateType = certificateType;
		this.imageName = imageName;
		this.backgroundImageName = backgroundImageName;
		this.rating = rating;
	}
	
	@NotNull(message="fullname should not be blank.")
	private String name;

	@NotBlank(message="screen type should not be blank.")
	private String screenType;

	@NotBlank(message="language should not be blank.")
	private String language;

	@NotBlank(message="duration should not be blank.")
	private String duration;

	@NotNull(message="release date should not be blank.")
	private Date releaseDate;

	@NotBlank(message="genre should not be blank.")
	private String genre;

	@NotBlank(message="certificate type should not be blank.")
	private String certificateType;

	@NotBlank(message="imageName type should not be blank.")
	private String imageName;
	
	@NotBlank(message="backgroundImageName type should not be blank.")
	private String backgroundImageName;
	
	@NotNull(message="rating should not be blank.")
	private Integer rating;

	
	
	
}
