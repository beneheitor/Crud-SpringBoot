package br.com.cadastro.sentry;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vilao")
public class DuGrau {

    @GetMapping
    public String get(){
        return """
                      _ _,---._
                   ,-','       `-.___
                  /-;'               `._
                 /\\/          ._   _,'o \\
                ( /\\       _,--'\\,','"`. )
                 |\\      ,'o     \\'    //\\
                 |      \\        /   ,--'""`-.
                 :       \\_    _/ ,-'         `-._
                  \\        `--'  /                )
                   `.  \\`._    ,'     ________,','
                     .--`     ,'  ,--` __\\___,;'
                      \\`.,-- ,' ,`_)--'  /`.,'
                       \\( ;  | | )      (`-/
                         `--'| |)       |-/
                           | | |        | |
                           | | |,.,-.   | |_
                           | `./ /   )---`  )
                          _|  /    ,',   ,-'
                 -hrr-   ,'|_(    /-<._,' |--,
                         |    `--'---.     \\/ \\
                         |          / \\    /\\  \\
                       ,-^---._     |  \\  /  \\  \\
                    ,-'        \\----'   \\/    \\--`.
                   /            \\              \\   \\
                """;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String post(){
        return """
                   ,  ,
                             / \\/ \\,'| _
                            ,'    '  ,' |,|
                           ,'           ' |,'|
                          ,'                 ;'| _
                         ,'                    '' |
                        ,'                        ;-,
                       (___                        /
                     ,'    `.  ___               ,'
                    :       ,`'   `-.           /
                    |-._ o /         \\         /
                   (    `-(           )       /
                  ,'`.     \\      o  /      ,'
                 /    `     `.     ,'      /
                (             `""\"'       /
                 `._                     /
                    `--.______        '"`.
                       \\__,__,`---._   '`;
                            ))`-^--')`,-'
                          ,',_____,'  |
                          \\_          `).
                  -hrr-     `.      _,'  `
                            /`-._,-'      \\
                """;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public String put(){
        return """
                   OOOO
                 OOOOOOOOO
                OOOOOOOOOOOO
                OOOOOOOOOOOOO
                OOOOOOOOOOOOOO
                OOOOOOOOOOOOOO
                 OOOOOOOOOOOOOO
                 OOOOOOOOOOOOOO
                 OOOOOOOOOOOOOO
                  OOOOOOOOOOOOOO
                  OOOOOOOOOOOOOO
                  OOOOOOOOOOOOOO
                  OOOOOOOOOOOOOO
                   OOOOOOOOOOOOOO
                   OOOOOOOOOOOOOO
                   OOOOO \\_| \\_|O
                   OOOO \\/  \\/  \\
                   OOOO (o   )o  )
                   O/c   \\__/ --.
                   O\\_   ,     -'
                    O|  '\\_______)
                     |       _)
                     |      |
                     oooooooo
                    /        \\
                """;
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(){
        return """
                      /\\  /\\
                  ___/  \\/  \\___
                 |             /
                 |            /_
                 /     \\_| \\_| /
                /     \\/  \\/  \\/
                \\     (o   )o  )
                 \\ /c  \\__/ --.
                 | \\_  ,     -'
                 |_ | '\\_______)
                   ||      _)
                    |     |
                    ooooooo
                   /       \\
                """;
    }
}
