package br.com.cadastro.sentry.application.service;

import br.com.cadastro.sentry.application.dto.UsersRequestDTO;
import br.com.cadastro.sentry.application.dto.UsersResponseDTO;
import br.com.cadastro.sentry.domain.entity.Users;
import br.com.cadastro.sentry.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UsersService {

    private final UserRepository userRepository;

    public List<Users> findAll() {
        return userRepository.findAll();
    }

    public Users findOneUser(UUID id) {
        Optional<Users> findedUser = userRepository.findById(id);
        if (findedUser.isPresent()) {
            return findedUser.get();
        } else {
            throw new RuntimeException("Usuário não encontrado!");
        }
    }

    public Users addUser(UsersRequestDTO usersRequestDTO){
        return userRepository.save(usersRequestDTO.toEntity());
    }


    public Users updateUser(UsersRequestDTO usersRequestDTO, UUID id) {
        Users existingUser = findOneUser(id);
        existingUser.setName(usersRequestDTO.name());
        existingUser.setCpf(usersRequestDTO.cpf());
        existingUser.setEmail(usersRequestDTO.email());
        existingUser.setSenha(usersRequestDTO.senha());

        return userRepository.save(existingUser);
    }

    public void delete(UUID id) {
        userRepository.delete(findOneUser(id));
    }

}
