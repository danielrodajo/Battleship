package com.daniel.hundirflota.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@ConfigurationProperties
@Component
public class BattleshipConfig {

	private JwtConfig jwtConfig;
	
	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}

	@Data
	public static class JwtConfig {
		private String secretKey;
	}
}
