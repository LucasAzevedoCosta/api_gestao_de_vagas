package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
    
}