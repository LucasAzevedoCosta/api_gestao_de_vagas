package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.repositories;

import  java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.entities.CompanyEntity;

public interface CompanyRepository extends  JpaRepository<CompanyEntity, UUID> {
    Optional<CompanyEntity> findByUsernameOrEmail(String username, String email);
    Optional<CompanyEntity> findByUsername(String username);
}
