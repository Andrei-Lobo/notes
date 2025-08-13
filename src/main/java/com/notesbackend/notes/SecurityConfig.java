package com.notesbackend.notes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // disable CSRF for testing
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/register", "/login").permitAll() // allow public access
                .anyRequest().authenticated() // all other requests need auth
            )
            .httpBasic(); // optional
        return http.build();
    }
}
