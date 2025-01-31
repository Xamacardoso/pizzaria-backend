package dev.xamanicolas.pizzaria_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()
                        .anyRequest().permitAll() // Permite acesso a todas as rotas sem login
                )
                .csrf(csrf -> csrf.disable()) // Desativa proteção CSRF (caso necessário)
                .headers(headers -> headers.frameOptions().disable())
                .formLogin(login -> login.disable()) // Remove a tela de login padrão
                .httpBasic(basic -> basic.disable()); // Desativa autenticação básica

        return http.build();
    }
}

