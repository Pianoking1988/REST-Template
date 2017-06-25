package de.heinemann.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

	/**
	 * Maps between java classes, like rest <-> api domain and api domain <-> respository domain. 
	 */
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
}
