package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileCandidateResponseDTO {

    private String description;
    private String username;
    private String email;
    private UUID id;
    private String name;
}
