package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static com.example.demo.constant.UrlConst.*;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {
    //パスワードをハッシュ化するためのメソッド
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //認証設定
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        //ログイン画面と登録画面はアクセス許可
                        .requestMatchers(NO_AUTHENTICATION)
                        .permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(
                        login -> login
                                .loginPage(LOGIN)
                                .usernameParameter("userid")
                                .passwordParameter("password")
                                //認証後必ずトップページに遷移するようにtrueを指定
                                .defaultSuccessUrl(TOP, true)
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/logout"));
        return http.build();
    }
}