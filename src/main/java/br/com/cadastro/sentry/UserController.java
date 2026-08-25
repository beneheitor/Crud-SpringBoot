package br.com.cadastro.sentry;

import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//import java.util.ArrayList;
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
        Users existingUser = findOneUser(id);
        existingUser.setName(user.getName());
        existingUser.setCpf(user.getCpf());
        existingUser.setEmail(user.getEmail());

        return userRepository.save(existingUser);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable UUID id) {
       userRepository.delete(findOneUser(id));
    }
}
