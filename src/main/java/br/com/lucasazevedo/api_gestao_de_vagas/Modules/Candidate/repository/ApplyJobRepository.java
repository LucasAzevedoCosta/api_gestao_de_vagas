package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.entity.ApplyJobEntity;

public interface ApplyJobRepository extends JpaRepository<ApplyJobEntity, UUID> {

}
