package com.example.demo.service; // Verifique se o package está igual ao seu projeto

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Obrigatório para o POST funcionar depois
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // Libera geral todas as rotas
            );
        return http.build();
    }
}