package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CandidateEntity {

    private UUID id;
    private String name;

    @Pattern(regexp = "^(?!\\s*$).+", message = "O campo [username] não pode ter espaços")
    private String username;

    @Email(message = "Insira um email válido")
    private String email;

    @Length(min = 8, max= 20, message = "A senha deve ter no mínimo 8 caracteres") 
    private String password;
    private String descripition;
    private String curriculum;    

}