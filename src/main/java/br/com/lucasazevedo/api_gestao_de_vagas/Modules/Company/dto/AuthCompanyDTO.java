package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthCompanyDTO {

  private String password;
  private String username;
}
