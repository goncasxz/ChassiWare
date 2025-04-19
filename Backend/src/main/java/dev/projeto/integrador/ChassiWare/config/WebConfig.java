package dev.projeto.integrador.ChassiWare.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // Marca a classe como uma configuração do Spring
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Habilita o CORS para todas as rotas da API
        registry.addMapping("/**") // Para todas as rotas
                .allowedOrigins("http://127.0.0.1:5500") // Permite o frontend da porta 3000 (ou a URL do seu frontend)
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Permite esses métodos
                .allowedHeaders("*") // Permite todos os cabeçalhos
                .allowCredentials(true); // Permite enviar cookies ou credenciais se necessário
    }
}
