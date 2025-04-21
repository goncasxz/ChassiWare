package dev.projeto.integrador.ChassiWare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class HashConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // Definindo o bean BCryptPasswordEncoder
        return new BCryptPasswordEncoder();
    }
}
