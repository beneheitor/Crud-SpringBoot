package br.com.cadastro.sentry.interface_ui;

import br.com.cadastro.sentry.application.dto.UsersRequestDTO;
import br.com.cadastro.sentry.application.dto.UsersResponseDTO;
import br.com.cadastro.sentry.application.service.UsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.util.ArrayList;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final
    UsersService usersService;


    //GET PARA RETORNAR TODOS OS USUÁRIOS
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UsersResponseDTO>> findAllUsers() {
        return ResponseEntity.ok(usersService.findAll());
    }

    //GET PARA RETORNAR APENAS UM USUÁRIO
    @GetMapping("/{id}")
    public ResponseEntity<UsersResponseDTO> findOneUser(@PathVariable UUID id) {
       return ResponseEntity.ok(usersService.findOneUser(id));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsersResponseDTO> addUser(@Valid @RequestBody UsersRequestDTO usersRequestDTO) {
        UsersResponseDTO userSaved = usersService.addUser(usersRequestDTO);
        return ResponseEntity.created(
                URI.create("/v1/users/" + userSaved.id())
        ).body(userSaved);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UsersResponseDTO> updateUser(@PathVariable UUID id, @RequestBody UsersRequestDTO usersRequestDTO) {
       return ResponseEntity.ok(usersService.updateUser(usersRequestDTO, id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
        usersService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
