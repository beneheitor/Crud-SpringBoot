package br.com.cadastro.sentry.interface_ui;

import br.com.cadastro.sentry.application.dto.UsersRequestDTO;
import br.com.cadastro.sentry.application.service.UsersService;
import br.com.cadastro.sentry.domain.entity.Users;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

//import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UsersService usersService;


    //GET PARA RETORNAR TODOS OS USUÁRIOS
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Users> findAllUsers() {
        return usersService.findAll();
    }

    //GET PARA RETORNAR APENAS UM USUÁRIO
    @GetMapping("/{id}")
    public Users findOneUser(@PathVariable UUID id) {
       return usersService.findOneUser(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Users addUser(@Valid @RequestBody UsersRequestDTO usersRequestDTO) {
        return usersService.addUser(usersRequestDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Users updateUser(@PathVariable UUID id, @RequestBody UsersRequestDTO usersRequestDTO) {
       return usersService.updateUser(usersRequestDTO, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable UUID id) {
       usersService.delete(id);
    }
}
