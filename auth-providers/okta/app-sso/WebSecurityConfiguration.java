package com.example

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
class WebSecurityConfiguration {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .oauth2Login(oauth2Login -> {
                })
                .oauth2Client(oauth2Client -> {
                })
                .authorizeHttpRequests(authorize -> authorize
                        .mvcMatchers("/api/**").authenticated() // RestController request mapping base url
                        .mvcMatchers("/").authenticated() // Controller for UI
                        .anyRequest().permitAll()
                );
        return http.build();
    }
}