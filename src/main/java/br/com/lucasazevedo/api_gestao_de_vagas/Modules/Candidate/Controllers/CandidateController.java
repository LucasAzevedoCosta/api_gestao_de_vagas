package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.CandidateEntity;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @PostMapping("/")
    public void create( @RequestBody CandidateEntity CandidateEntity ) {
        System.out.println("Candidato");
        System.out.println(CandidateEntity.getEmail());
    }

}