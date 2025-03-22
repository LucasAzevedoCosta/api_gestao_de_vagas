package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.dto.ProfileCandidateResponseDTO;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.repository.CandidateRepository;
import br.com.lucasazevedo.api_gestao_de_vagas.exceptions.UserNotFoundException;

@Service
public class ProfileCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDTO execute(UUID idCandidate) {
        var candidate = this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> {
                    throw new UserNotFoundException();
                });

        var candidateDTO = ProfileCandidateResponseDTO.builder()
                .description(candidate.getDescripition())
                .username(candidate.getUsername())
                .email(candidate.getEmail())
                .name(candidate.getName())
                .id(candidate.getId())
                .build();

        return candidateDTO;
    }
}
