package mx.htsoft.spring.boot.microservices.app.item;
import mx.htsoft.spring.boot.microservices.app.item.security.JwtAuthenticationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception{
			http.csrf().disable()
					.addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
					.authorizeRequests()
					.antMatchers(HttpMethod.POST, "/api/login").permitAll()
					.antMatchers(HttpMethod.POST, "/api/articulo").permitAll()
					.antMatchers(HttpMethod.GET, "/api/articulo").permitAll()
					.antMatchers(HttpMethod.PUT, "/api/articulo/{id}").permitAll()
					.antMatchers(HttpMethod.DELETE, "/api/articulo/{id}").permitAll()
					.antMatchers(HttpMethod.GET, "/api/ventas").permitAll()
					.antMatchers(HttpMethod.OPTIONS).permitAll()
					.anyRequest().authenticated();
		}

		@Bean
		public FilterRegistrationBean processCorsFilter() {
			final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			final CorsConfiguration config = new CorsConfiguration();
			config.setAllowCredentials(false);
			config.addAllowedOrigin("http://localhost:4200");
			config.addAllowedHeader("*");
			config.addAllowedMethod("*");
			source.registerCorsConfiguration("/**", config);


			final FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
			bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
			return bean;
		}
		
	}
}
