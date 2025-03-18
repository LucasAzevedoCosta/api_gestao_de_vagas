package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "Candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Schema(example = "Maria de Silva", requiredMode = RequiredMode.REQUIRED, description = "Nome do candidato")
    private String name;
    
    @NotBlank
    @Pattern(regexp = "\\S+", message = "O campo [username] não pode ter espaços")
    @Schema(example = "Maria", requiredMode = RequiredMode.REQUIRED, description = "Username do candidato")
    private String username;

    @Email(message = "Insira um email válido")
    @Schema(example = "maria@gmail.com", requiredMode = RequiredMode.REQUIRED, description = "E-mail do candidato")
    private String email;

    @Length(min = 8, max= 200, message = "A senha deve ter no mínimo 8 caracteres") 
    private String password;

    @Schema(example = "admin@1234", minLength = 10, maxLength = 100, requiredMode = RequiredMode.REQUIRED, description = "Senha do candidato")
    private String descripition;
    private String curriculum;

    @CreationTimestamp()
    private LocalDateTime createdAt;

}