package br.com.lucasazevedo.api_gestao_de_vagas.modules.candidate.useCases;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.CandidateRepository;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Candidate.useCases.ApplyJobCandidateUseCase;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.repositories.JobRepository;
import br.com.lucasazevedo.api_gestao_de_vagas.exceptions.UserNotFoundException;

@ExtendWith(MockitoExtension.class)
public class ApplyJobCandidateUseCaseTest {

    @InjectMocks
    private ApplyJobCandidateUseCase applyJobCandidateUseCase;

    @Mock
    private CandidateRepository candidateRepository;

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
}
