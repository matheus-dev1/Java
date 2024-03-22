package br.com.matheus.spring.learning.matheuslearningjava18spring3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/*
* Diferencas da anotacao @Controller para @RestController
*
* Em resumo
* Basicamente a RestController tem tudo o que tem na Controller, que sao as anotacoes Controller e ResponseBody,
* mas a ideia da RestController eh retornar um conteudo e nao uma pagina processada (HTML, CSS e JavaScript)
*
* Em complemento
* Uma controller que nao seria uma API Rest retornaria uma "pagina" (HTML, CSS e JavaScript) processadas, ele
* processaria os dados e encontraria um endpoint para retornar as informacoes
* */
@RestController
public class GrettingsController {

    private static final String template = "Hello, %s, %s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/grettings")
    public Grettings grettings(
            @RequestParam(value = "name", defaultValue = "World") String name
            ) {
        // format metodo needs %s
        return new Grettings(counter.incrementAndGet(), String.format(template, name, "testando"));
    }
}
