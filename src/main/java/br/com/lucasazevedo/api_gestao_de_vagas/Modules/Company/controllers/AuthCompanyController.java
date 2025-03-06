package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.controllers;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.dto.AuthCompanyDTO;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.useCases.AuthCompanyUseCase;

@RestController
@RequestMapping("/auth")
public class AuthCompanyController {
    

    @Autowired
    private AuthCompanyUseCase authCompanyUseCase;


    @PostMapping("/company")
    public ResponseEntity<Object> create(@RequestBody AuthCompanyDTO authCompanyDTO) {
        try {
            var result = authCompanyUseCase.execute(authCompanyDTO);
            return ResponseEntity.ok(result);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
  }
}
