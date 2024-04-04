package com.JavaTech.Sample.group.Loginservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


import java.util.Locale;

@SpringBootApplication
@EnableWebMvc
public class LoginServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(LoginServiceApplication.class, args);
	}


	

}
//mvc - c -controller /login