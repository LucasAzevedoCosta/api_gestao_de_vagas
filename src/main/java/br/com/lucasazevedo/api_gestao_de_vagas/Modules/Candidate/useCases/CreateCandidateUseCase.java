package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.CandidateEntity;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.CandidateRepository;
import br.com.lucasazevedo.api_gestao_de_vagas.exceptions.UserFoundException;


@Service
public class CreateCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity CandidateEntity) {
        this.candidateRepository
        .findByUsernameOrEmail(CandidateEntity.getUsername(), CandidateEntity.getEmail())
        .ifPresent(user -> {
            throw new UserFoundException();
        });
        return this.candidateRepository.save(CandidateEntity);
    }

}
