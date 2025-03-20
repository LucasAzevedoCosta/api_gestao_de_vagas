package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.entities.JobEntity;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.repositories.CompanyRepository;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.repositories.JobRepository;
import br.com.lucasazevedo.api_gestao_de_vagas.exceptions.CompanyNotFoundException;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
     private CompanyRepository companyRepository;

    public JobEntity execute(JobEntity jobEntity) {
        companyRepository.findById(jobEntity.getCompanyId()).orElseThrow(() -> {
             throw new CompanyNotFoundException();
         });
        return this.jobRepository.save(jobEntity);
    }
}
