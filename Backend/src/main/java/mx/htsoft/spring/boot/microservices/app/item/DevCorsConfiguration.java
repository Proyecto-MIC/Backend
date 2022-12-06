package mx.htsoft.spring.boot.microservices.app.item;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class DevCorsConfiguration implements WebMvcConfigurer{
	
	 @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/api/**")
	                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS")
	                .exposedHeaders("Authorization");
	    }

}
