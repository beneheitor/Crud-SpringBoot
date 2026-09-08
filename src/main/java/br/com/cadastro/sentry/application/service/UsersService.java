package br.com.cadastro.sentry.application.service;

import br.com.cadastro.sentry.application.dto.UsersRequestDTO;
import br.com.cadastro.sentry.application.dto.UsersResponseDTO;
import br.com.cadastro.sentry.domain.entity.Users;
import br.com.cadastro.sentry.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class UsersService {

    private final UserRepository userRepository;

    public List<UsersResponseDTO> findAll() {
//        userRepository.findAll().forEach(
//                UsersResponseDTO::fromEntity
//        );
        return userRepository.findAll().stream()
                .map(UsersResponseDTO::fromEntity)
                .toList();
    }

    public UsersResponseDTO findOneUser(UUID id) {
        Optional<Users> findedUser = userRepository.findById(id);
        if (findedUser.isPresent()) {
            return UsersResponseDTO.fromEntity(findedUser.get());
        } else {
            throw new RuntimeException("Usuário não encontrado!");
        }
    }

    public UsersResponseDTO addUser(UsersRequestDTO usersRequestDTO) {
        return UsersResponseDTO.fromEntity(userRepository.save(usersRequestDTO.toEntity()));
    }


    public UsersResponseDTO updateUser(UsersRequestDTO usersRequestDTO, UUID id) {
//        Users existingUser = findOneUser(id);
//        existingUser.setName(usersRequestDTO.name());
//        existingUser.setCpf(usersRequestDTO.cpf());
//        existingUser.setEmail(usersRequestDTO.email());
//        existingUser.setSenha(usersRequestDTO.senha());

        Users existingUser = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuário não encontrado!")
        );

        existingUser.setName(usersRequestDTO.name());
        existingUser.setCpf(usersRequestDTO.cpf());
        existingUser.setEmail(usersRequestDTO.email());
        existingUser.setSenha(usersRequestDTO.senha());

        return UsersResponseDTO.fromEntity(userRepository.save(existingUser));
    }

    public void delete(UUID id) {
//        Users existingUser = userRepository.findById(id).orElseThrow(
//                () -> new RuntimeException("Usuário não encontrado!")
//        );
//        userRepository.delete(existingUser);
        if (userRepository.existsById(id))
            userRepository.deleteById(id);
        else
            throw new RuntimeException("Usuário não encontrado");

    }

}
