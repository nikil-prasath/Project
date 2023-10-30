package com.organization.employeeservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableWebMvc
public class EmployeeServiceApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}
	
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		registry.addMapping("/**").allowedMethods("GET","POST");
		WebMvcConfigurer.super.addCorsMappings(registry);
	}

}
