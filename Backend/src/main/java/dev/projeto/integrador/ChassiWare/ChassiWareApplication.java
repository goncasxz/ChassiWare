package dev.projeto.integrador.ChassiWare;

import dev.projeto.integrador.ChassiWare.config.HashConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan(basePackages = "dev.projeto.integrador.ChassiWare")
@Import(HashConfig.class)
public class ChassiWareApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChassiWareApplication.class, args);
	}

}
