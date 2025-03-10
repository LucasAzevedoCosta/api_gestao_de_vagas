package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.entities.JobEntity;

public interface JobRepository extends JpaRepository<JobEntity, UUID> {
    List<JobEntity> findByDescriptionContaining(String title);
}
