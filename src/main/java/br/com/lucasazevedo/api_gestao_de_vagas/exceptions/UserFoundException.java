package br.com.lucasazevedo.api_gestao_de_vagas.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
        super("Usuario já existente");
    }
}