package br.com.cadastro.sentry.application.dto;

import br.com.cadastro.sentry.domain.entity.Users;

public record UsersRequestDTO (
        String name,
        String cpf,
        String email,
        String senha
){
    public Users toEntity(){
        return new Users(
                null,
                name,
                cpf,
                email,
                senha
        );
    }
}
