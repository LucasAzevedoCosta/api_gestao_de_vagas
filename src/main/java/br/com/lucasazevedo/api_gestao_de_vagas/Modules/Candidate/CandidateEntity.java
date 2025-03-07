package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

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
    
    private String name;
    
    @NotBlank
    @Pattern(regexp = "\\S+", message = "O campo [username] não pode ter espaços")
    private String username;

    @Email(message = "Insira um email válido")
    private String email;

    @Length(min = 8, max= 200, message = "A senha deve ter no mínimo 8 caracteres") 
    private String password;
    private String descripition;
    private String curriculum;

    @CreationTimestamp()
    private LocalDateTime createdAt;

}