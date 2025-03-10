package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.entities.JobEntity;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.repositories.JobRepository;

@Service
public class ListAllJobsByFilterUseCase {
    

    @Autowired
    JobRepository jobRepository;

    public List<JobEntity> execute(String filter) {
        return this.jobRepository.findByDescriptionContaining(filter);
    }
}
