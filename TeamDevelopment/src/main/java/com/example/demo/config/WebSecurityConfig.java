package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static com.example.demo.constant.UrlConst.NO_AUTHENTICATION;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(NO_AUTHENTICATION)
                        .permitAll()
                        .anyRequest().authenticated()


                )


                .formLogin(
                        login -> login
                                .loginPage("/login")
                                .usernameParameter("userid")
                                .passwordParameter("password")
                                .defaultSuccessUrl("/top")
                );
        return http.build();
    }
}