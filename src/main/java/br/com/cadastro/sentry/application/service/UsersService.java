package br.com.cadastro.sentry.application.service;

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

    public Users addUser(Users user){
        return userRepository.save(user);
    }


    public Users updateUser(Users user, UUID id) {
        Users existingUser = findOneUser(id);
        existingUser.setName(user.getName());
        existingUser.setCpf(user.getCpf());
        existingUser.setEmail(user.getEmail());

        return userRepository.save(existingUser);
    }

    public void delete(UUID id) {
        userRepository.delete(findOneUser(id));
    }

}
