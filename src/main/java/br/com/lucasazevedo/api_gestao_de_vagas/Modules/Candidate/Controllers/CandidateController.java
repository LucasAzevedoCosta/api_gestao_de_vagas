package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.CandidateEntity;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.useCases.CreateCandidateUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create( @Valid @RequestBody CandidateEntity CandidateEntity ) {
        try{
            var result = this.createCandidateUseCase.execute(CandidateEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}