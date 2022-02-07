package com.daniel.hundirflota.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@ConfigurationProperties
@Component
public class BattleshipConfig {

	private JwtConfig jwtConfig;
	

	@Data
	public static class JwtConfig {
		private String secretKey;
	}
}
