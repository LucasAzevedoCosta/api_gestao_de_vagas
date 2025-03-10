package br.com.lucasazevedo.api_gestao_de_vagas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Gestão de Vagas", description = "API responsável por gerenciar vagas de emprego", version = "1"))
public class ApiGestaoDeVagasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGestaoDeVagasApplication.class, args);
	}

}
