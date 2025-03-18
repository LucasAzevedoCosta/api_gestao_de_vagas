package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.entity.CandidateEntity;

public interface  CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
    Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);

    Optional<CandidateEntity> findByUsername(String username);
}