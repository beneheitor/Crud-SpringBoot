package br.com.cadastro.sentry.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

//import java.util.Objects;
import java.util.UUID;

@Entity
@Table(
        name = "Usuarios",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_usuario_cpf", columnNames = "cpf"),
                @UniqueConstraint(name = "uk_usuario_email", columnNames = "email")
        },
        indexes = {
                @Index(name = "idx_usuario_nome", columnList = "name"),
                @Index(name = "idx_usuario_email", columnList = "email")
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@EqualsAndHashCode
//@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @NotEmpty
    @NotBlank(message = "Senha é obrigatório!")
    @Size(min = 2, max = 8, message = "Senha deve ter entre 2 e 8 caracteres")
    @Column(name = "senha", nullable = false, length = 8)
    private String senha;


    @NotEmpty
    @NotBlank(message = "Nome é obrigatório!")
    @Size(min = 2, max = 150, message = "Nome deve ter entre 2 e 150 caracteres")
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @NotBlank(message = "CPF obrigatório!")
    @Pattern(regexp = "\\d{11}", message = "CPF deve ter exatamente 11 caracteres")
    @Column(name = "cpf", nullable = false, length = 11, unique = true)
    private String cpf;

    @NotBlank(message = "E-mail obrigatório!")
    @Email(message = "E-mail inválido")
    @Size(min = 10, max = 255, message = "E-mail deve ter entre 10 e 255 caracteres")
    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @PrePersist
    @PreUpdate
    private void dataNormalize(){
        if (this.name != null){
            this.name = this.name.trim();
        }
        if (this.cpf != null){
            this.cpf = this.cpf.replaceAll("\\D","");
        }
        if (this.email != null){
            this.email = this.email.toLowerCase();
        }
    }

}
