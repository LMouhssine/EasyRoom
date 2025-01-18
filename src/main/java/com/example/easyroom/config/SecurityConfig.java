package com.example.easyroom.config;

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
        http
            .csrf(csrf -> csrf.disable())  // Désactiver CSRF pour les API
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**", "/css/**", "/js/**", "/etudiants", "/formations").permitAll()  // Autoriser l'accès aux API et aux ressources statiques
                .anyRequest().authenticated()  // Toutes les autres routes nécessitent une authentification
            );

        return http.build();
    }
}