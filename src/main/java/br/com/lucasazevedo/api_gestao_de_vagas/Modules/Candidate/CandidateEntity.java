package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate;

import java.util.UUID;

import lombok.Data;

@Data
public class CandidateEntity {

    private UUID id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String descripition;
    private String curriculum;    

}