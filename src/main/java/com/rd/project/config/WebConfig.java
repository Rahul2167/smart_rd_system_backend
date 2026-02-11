package com.rd.project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOriginPatterns("https://*.onrender.com", "http://localhost:5173", "http://localhost:3000", "*") // Explicitly
																														// allow
																														// Render
																														// &
																														// Localhost
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Fixed typo: OPTION -> OPTIONS
				.allowedHeaders("*")
				.allowCredentials(true)
				.maxAge(3600);
	}
}
