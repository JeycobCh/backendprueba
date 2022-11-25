package pe.edu.upao.sistemas.tiendaropa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TiendaRopaApplication {

	public static void main(String[] args) {

		SpringApplication.run(TiendaRopaApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurar() {
		return new WebMvcConfigurer() {

			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200/");
			}
		};
	}
}