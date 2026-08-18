package br.com.cadastro.sentry;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    List<Users> registeredUsers = new ArrayList<>();

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Users> findAllUsers(){
        return registeredUsers;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Users addUser(@RequestBody Users user){
        registeredUsers.add(user);
        return registeredUsers.getLast();
    }
}
