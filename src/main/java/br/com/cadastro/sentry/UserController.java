package br.com.cadastro.sentry;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Users getUser(){
        return new Users("Heitor","999.999.999-10","pedroberingeladuGRAU@gemeiu.com");
    }
}
