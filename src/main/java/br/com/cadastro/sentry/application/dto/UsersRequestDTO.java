package br.com.cadastro.sentry.application.dto;

import br.com.cadastro.sentry.domain.entity.Users;

import jakarta.validation.constraints.*;

public record UsersRequestDTO (
        @NotEmpty
        @NotBlank(message = "Nome é obrigatório!")
        @Size(min = 2, max = 150, message = "Nome deve ter entre 2 e 150 caracteres")
        String name,

        @NotBlank(message = "CPF obrigatório!")
        @Pattern(regexp = "\\d{11}", message = "CPF deve ter exatamente 11 caracteres")
        String cpf,

        @NotBlank(message = "E-mail obrigatório!")
        @Email(message = "E-mail inválido")
        @Size(min = 10, max = 255, message = "E-mail deve ter entre 10 e 255 caracteres")
        String email,


        @NotEmpty
        @NotBlank(message = "Senha é obrigatório!")
        @Size(min = 2, max = 12, message = "Senha deve ter entre 2 e 8 caracteres")
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
