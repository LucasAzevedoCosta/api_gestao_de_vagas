package br.com.lucasazevedo.api_gestao_de_vagas.modules.candidate.useCases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.entity.ApplyJobEntity;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.entity.CandidateEntity;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.repository.ApplyJobRepository;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.repository.CandidateRepository;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.useCases.ApplyJobCandidateUseCase;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.entities.JobEntity;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.repositories.JobRepository;
import br.com.lucasazevedo.api_gestao_de_vagas.exceptions.JobNotFoundException;
import br.com.lucasazevedo.api_gestao_de_vagas.exceptions.UserNotFoundException;

@ExtendWith(MockitoExtension.class)
public class ApplyJobCandidateUseCaseTest {

    @InjectMocks
    private ApplyJobCandidateUseCase applyJobCandidateUseCase;

    @Mock
    private CandidateRepository candidateRepository;

    @Mock
    private ApplyJobRepository applyJobRepository;

    @Mock
    private JobRepository jobRepository;

    @Test
    @DisplayName("Should not be able to apply for a job if candidate does not found")
    public void should_not_be_apply_jon_with_candidate_not_found() {
        try {
            applyJobCandidateUseCase.execute(null, null);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(UserNotFoundException.class);
        }
    }

    @Test
    public void should_not_be_able_to_apply_job_with_job_not_found() {

        var idCandidate = UUID.randomUUID();

        var candidate = new CandidateEntity();

        when(candidateRepository.findById(idCandidate)).thenReturn(Optional.of(candidate));

        try {
            applyJobCandidateUseCase.execute(idCandidate, null);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(JobNotFoundException.class);
        }
    }

    @Test
    public void should_be_able_to_create_a_new_apply_job() {
         var idCandidate = UUID.randomUUID();
        var idJob = UUID.randomUUID();

        var applyJobCreated = ApplyJobEntity.builder()
                .id(UUID.randomUUID())
                .build();

        when(candidateRepository.findById(idCandidate)).thenReturn(Optional.of(new CandidateEntity()));
        when(jobRepository.findById(idJob)).thenReturn(Optional.of(new JobEntity()));

        // Utilizando ArgumentMatchers.any() para flexibilizar o stubbing
        when(applyJobRepository.save(any(ApplyJobEntity.class))).thenReturn(applyJobCreated);

        var result = applyJobCandidateUseCase.execute(idCandidate, idJob);

        assertThat(result).hasFieldOrProperty("id");
        assertNotNull(result.getId());

    }
}
