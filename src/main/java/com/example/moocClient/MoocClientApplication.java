package com.example.moocClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class MoocClientApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(MoocClientApplication.class, args);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("error");
		registry.addViewController("/fail").setViewName("error");
	}


}
