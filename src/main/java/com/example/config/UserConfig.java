package com.example.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shivi Created on 12-04-2022
 *
 */

@Configuration
public class UserConfig {

	@Bean(name = "modelMapper")
	public ModelMapper modelMapper() {
		ModelMapper mapper = new ModelMapper();
		return mapper;
	}

}
