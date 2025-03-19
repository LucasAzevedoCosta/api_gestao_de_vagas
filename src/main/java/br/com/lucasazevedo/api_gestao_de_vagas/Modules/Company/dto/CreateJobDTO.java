package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateJobDTO {

    @Schema(example = "Vaga para pessoa desenvolvedora júnior", requiredMode = RequiredMode.REQUIRED)
    private String description;

    @Schema(example = "GymPass, Plano de saúde", requiredMode = RequiredMode.REQUIRED)
    private String benefits;

    @Schema(example = "JUNIOR", requiredMode = RequiredMode.REQUIRED)
    private String level;
}
