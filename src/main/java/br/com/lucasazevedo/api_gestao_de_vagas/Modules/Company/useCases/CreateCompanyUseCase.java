package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.entities.CompanyEntity;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.repositories.CompanyRepository;
import br.com.lucasazevedo.api_gestao_de_vagas.exceptions.UserFoundException;

@Service
public class CreateCompanyUseCase {

    @Autowired
    private CompanyRepository companyRepository;

    public CompanyEntity execute(CompanyEntity companyEntity) {

        this.companyRepository
                .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
                .ifPresent(user -> {
                    throw new UserFoundException();
                });

        return this.companyRepository.save(companyEntity);

    }
}
