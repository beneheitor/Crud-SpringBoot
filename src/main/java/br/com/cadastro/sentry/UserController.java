package br.com.cadastro.sentry;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    List<Users> registeredUsers = new ArrayList<>();

    //GET PARA RETORNAR TODOS OS USUÁRIOS
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Users> findAllUsers(){
        return registeredUsers;
    }

    //GET PARA RETORNAR APENAS UM USUÁRIO
    @GetMapping("/{id}")
    public Users findOneUser(@PathVariable int id){
        return registeredUsers.get(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Users addUser(@RequestBody Users user){
        registeredUsers.add(user);
        return registeredUsers.getLast();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Users updateUser(@PathVariable int id, @RequestBody Users user){
        registeredUsers.set(id,user);
        return registeredUsers.get(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id){
            registeredUsers.remove(id);
    }
}
