package br.com.cast.movie;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.cast.movie.interceptor.ProtegidoInterceptor;

@Configuration
@EnableWebMvc
public class Configurer implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE",
				"CONNECT");
	}
	
	@Bean
	public ProtegidoInterceptor protegidoInterceptor() {
		return new ProtegidoInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(protegidoInterceptor());
	}
}
