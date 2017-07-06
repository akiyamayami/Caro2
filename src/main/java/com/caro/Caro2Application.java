package com.caro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.caro.controller.Controller2;

@SpringBootApplication
@ComponentScan(basePackageClasses = Controller2.class)
public class Caro2Application {

	public static void main(String[] args) {
		SpringApplication.run(Caro2Application.class, args);
	}
	
	@Bean
	public ViewResolver getViewResolver() {
	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	    resolver.setPrefix("/WEB-INF/jsp/");
	    resolver.setSuffix(".jsp");
	    resolver.setViewClass(JstlView.class);
	    return resolver;
	}
}
