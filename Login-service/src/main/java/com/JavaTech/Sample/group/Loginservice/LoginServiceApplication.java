package com.JavaTech.Sample.group.Loginservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class LoginServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(LoginServiceApplication.class, args);
	}

	@Bean
	public LocaleResolver localeResolver(){

		SessionLocaleResolver locale = new SessionLocaleResolver();//session //request /login, /register

		locale.setDefaultLocale(Locale.ENGLISH);

		return locale;
	}

	@Bean
	public ResourceBundleMessageSource resourceBundleMessageSource (){
		ResourceBundleMessageSource message = new ResourceBundleMessageSource();
		message.setBasename("messages");// meessages.prp, messgaes_ta.prop
		return message;
	}

}
//mvc - c -controller /login