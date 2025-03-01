package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.entities.CompanyEntity;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.useCases.CreateCompanyUseCase;

@RestController
@RequestMapping("/company")
public class CompanyController {
    
    @Autowired
    private CreateCompanyUseCase createCompanyUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> Create(@RequestBody CompanyEntity companyEntity) {

        try {
            var result = this.createCompanyUseCase.execute(companyEntity);
                return ResponseEntity.ok().body(result);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
}
