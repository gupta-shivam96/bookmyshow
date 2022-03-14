package com.webapp.bookmyshowapp.messages;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;
import lombok.Setter;

@Configuration
@PropertySource("classpath:messages.properties")
@Getter@Setter
public class CommonErrorMessageConstant {
	
	@Value("${error.field.blank}")
	private String blankError;
	
	@Value("${error.uniquekey}")
	private String uniqueKeyError;
	
	@Value("${error.field.empty}")
	private String emptyError;
	
}
