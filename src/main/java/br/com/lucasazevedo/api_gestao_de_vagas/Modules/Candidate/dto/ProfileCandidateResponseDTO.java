package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.dto;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileCandidateResponseDTO {

   @Schema(example = "Desenvolvedora Java")
    private String description;

    @Schema(example = "maria")
    private String username;

    @Schema(example = "maria@gmail.com")
    private String email;
    private UUID id;

    @Schema(example = "Maria de Souza")
    private String name;
}
