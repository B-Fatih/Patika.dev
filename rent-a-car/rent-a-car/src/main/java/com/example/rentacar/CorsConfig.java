package com.example.rentacar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Allow requests from a specific origin (replace with your client's origin)
        config.addAllowedOrigin("http://localhost:3000");

        // Allow common HTTP methods
        config.addAllowedMethod("*");

        // Allow common headers
        config.addAllowedHeader("*");

        source.registerCorsConfiguration("/**", config);

        return new CorsFilter((CorsConfigurationSource) source);
    }
}