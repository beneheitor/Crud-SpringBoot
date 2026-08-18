package br.com.cadastro.sentry;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//@EqualsAndHashCode
//@Data
public class Users {
    private String nome;
    private String cpf;
    private String email;

}
