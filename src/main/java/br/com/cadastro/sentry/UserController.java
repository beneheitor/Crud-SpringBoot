package br.com.cadastro.sentry;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {


    private final UserRepository userRepository;

//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }


    //GET PARA RETORNAR TODOS OS USUÁRIOS
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Users> findAllUsers() {
        return userRepository.findAll();
    }

    //GET PARA RETORNAR APENAS UM USUÁRIO
    @GetMapping("/{id}")
    public Users findOneUser(@PathVariable UUID id) {
        Optional<Users> findedUser = userRepository.findById(id);
        if (findedUser.isPresent()) {
            return findedUser.get();
        } else {
            throw new RuntimeException("Usuário não encontrado!");
        }
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Users addUser(@RequestBody Users user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Users updateUser(@PathVariable UUID id, @RequestBody Users user) {
        Optional<Users> userSaved = userRepository.findById(id);
        if (userSaved.isPresent()) {
            Users userUpdated = userSaved.get();
            userUpdated.setNome(user.getNome());
            userUpdated.setCpf(user.getCpf());
            userUpdated.setEmail(user.getEmail());
            return userRepository.save(userUpdated);
        } else {
            throw new RuntimeException("Usuário não encontrado com o ID: " + id);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable UUID id) {
        Optional<Users> usersOptional = userRepository.findById(id);
        if (usersOptional.isPresent()){
            Users userDeleted = usersOptional.get();
            userRepository.delete(userDeleted);
        } else {
            throw new RuntimeException("Usuário não encontrado com o ID: " + id);
        }
    }
}
