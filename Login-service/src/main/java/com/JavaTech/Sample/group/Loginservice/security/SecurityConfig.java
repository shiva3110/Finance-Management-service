package com.JavaTech.Sample.group.Loginservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

       http.csrf().disable()// disabling csrf which mean any site can send request
               .authorizeRequests()//authorization (to check user and admin type)
               .requestMatchers("/actuator/**").permitAll()
               .anyRequest().authenticated()// checks username and password
               .and().httpBasic();// authentication way (basic Auth, OAuth, Oauth2)
       return http.build();
   }

}
