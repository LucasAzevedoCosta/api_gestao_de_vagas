package br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.useCases;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.dto.AuthCompanyDTO;
import br.com.lucasazevedo.api_gestao_de_vagas.Modules.Company.repositories.CompanyRepository;

@Service
public class AuthCompanyUseCase {


    @Value("${security.token.secret}")
    private String secretKey;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String execute(AuthCompanyDTO authCompanyDTO) throws AuthenticationException {
        var company = this.companyRepository.findByUsername(authCompanyDTO.getUsername()).orElseThrow(() -> {
            throw new UsernameNotFoundException("Username/password incorrect");
        });

        var passwordMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

        if (!passwordMatches) {
        throw new AuthenticationException();
        }


        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        var token = JWT.create().withIssuer("Lucas.inc")
            .withSubject(company.getId().toString()).sign(algorithm);

        return token;
    }
}
