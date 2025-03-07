package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.CandidateEntity;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.CandidateRepository;
import br.com.lucasazevedo.api_gestao_de_vagas.exceptions.UserFoundException;


@Service
public class CreateCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository
        .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent(user -> {
            throw new UserFoundException();
        });

        var password = passwordEncoder.encode(candidateEntity.getPassword());
        candidateEntity.setPassword(password);

        return this.candidateRepository.save(candidateEntity);
    }
}
