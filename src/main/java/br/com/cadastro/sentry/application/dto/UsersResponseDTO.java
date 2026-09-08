package br.com.cadastro.sentry.application.dto;

import br.com.cadastro.sentry.domain.entity.Users;

import java.util.UUID;

public record UsersResponseDTO (
        UUID id,
        String name,
        String cpf,
        String email
){
    public static UsersResponseDTO fromEntity(Users user){
        return new UsersResponseDTO(
                user.getId(),
                user.getName(),
                user.getCpf(),
                user.getEmail()
        );
    }
}
