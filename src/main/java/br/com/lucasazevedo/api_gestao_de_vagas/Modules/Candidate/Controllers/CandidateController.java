package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.Controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.CandidateEntity;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.useCases.CreateCandidateUseCase;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.useCases.ListAllJobsByFilterUseCase;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.useCases.ProfileCandidateUseCase;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.entities.JobEntity;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/CANDIDATE")
public class CandidateController {

    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;

    @Autowired
    private ProfileCandidateUseCase profileCandidateUseCase;

    @Autowired
    private ListAllJobsByFilterUseCase listAllJobsByFilterUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity CandidateEntity) {
        try {
            var result = this.createCandidateUseCase.execute(CandidateEntity);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('CANDIDATE')")
    public ResponseEntity<Object> get(HttpServletRequest request) {
        var idCandidate = request.getAttribute("candidate_id");

        try {
            var profile = this.profileCandidateUseCase
                    .execute(UUID.fromString(idCandidate.toString()));
            return ResponseEntity.ok().body(profile);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/job")
    @PreAuthorize("hasRole('CANDIDATE')")
    public List<JobEntity> findJobByFilter(@RequestParam String filter){
        return this.listAllJobsByFilterUseCase.execute(filter);
    }
}
