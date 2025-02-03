package br.com.matheus.spring.learning.matheuslearningjava18spring3.controllers;

import br.com.matheus.spring.learning.matheuslearningjava18spring3.models.Grettings;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;
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
@RequestMapping("/api")
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

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name;
    }

    @GetMapping("/dados")
    public ResponseEntity<JsonNode> getDadosJson() {
        ObjectMapper mapper = new ObjectMapper();

        try (InputStream inputStream = getClass().getResourceAsStream("/file.json")) {
            if (inputStream == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(mapper.createObjectNode().put("error", "Arquivo 'dados.json' não encontrado."));
            }

            JsonNode jsonNode = mapper.readTree(inputStream);
            return ResponseEntity.ok(jsonNode);

        } catch (Exception e) {
            JsonNode errorNode = mapper.createObjectNode().put("error", "Erro ao ler o arquivo JSON.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorNode);
        }
    }

    @GetMapping("/content_negotiation")
    public Grettings getGrettings() {
        return new Grettings(1, "1");
    }
}
