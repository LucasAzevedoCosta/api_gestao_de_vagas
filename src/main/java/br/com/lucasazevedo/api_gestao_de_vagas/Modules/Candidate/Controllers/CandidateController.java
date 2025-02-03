package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.CandidateEntity;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.CandidateRepository;
import br.com.lucasazevedo.api_gestao_de_vagas.exceptions.UserFoundException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;

    @PostMapping("/")
    public CandidateEntity create( @Valid @RequestBody CandidateEntity CandidateEntity ) {
        this.candidateRepository
        .findByUsernameOrEmail(CandidateEntity.getUsername(), CandidateEntity.getEmail())
        .ifPresent(user -> {
            throw new UserFoundException();
        });
        return this.candidateRepository.save(CandidateEntity);
    }

}