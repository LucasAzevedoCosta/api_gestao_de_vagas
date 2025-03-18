package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.repository.ApplyJobRepository;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.repository.CandidateRepository;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.repositories.JobRepository;
import br.com.lucasazevedo.api_gestao_de_vagas.exceptions.JobNotFoundException;
import br.com.lucasazevedo.api_gestao_de_vagas.exceptions.UserNotFoundException;

@Service
public class ApplyJobCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplyJobRepository applyJobRepository;

    // ID do candidato
    // ID da vaga
    public void execute(UUID idCandidate, UUID idJob) {
        // Validar se o candidato existe
        this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UserNotFoundException();
                });

        // Validar se a vaga existe
        this.jobRepository.findById(idJob)
                .orElseThrow(() -> {
                    throw new JobNotFoundException();
                });

        // Candidato se inscrever na vaga
    }
}
