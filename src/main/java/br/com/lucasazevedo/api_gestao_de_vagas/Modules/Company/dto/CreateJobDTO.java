package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.dto;

import lombok.Data;

@Data
public class CreateJobDTO {

    private String description;
    private String benefits;
    private String level;
}
