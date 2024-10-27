package br.com.matheus.spring.learning.matheuslearningjava18spring3.controllers;

import br.com.matheus.spring.learning.matheuslearningjava18spring3.data.vo.v1.PersonVO;
import br.com.matheus.spring.learning.matheuslearningjava18spring3.data.vo.v2.PersonVOV2;
import br.com.matheus.spring.learning.matheuslearningjava18spring3.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    /*
    * O parametro "produces" garante que o metodo/request que eu estou fazendo vai produzir/retornar o tipo especificado
    * Neste exemplo eu quero que o objeto Person seja retornado em formado json
    * */
    @GetMapping(
            value = "/{id}",
            // Mantendo estas linhas por conta do Swegger
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonVO getFindById(
        @PathVariable(value = "id") Long id
    ) {
        return personService.findById(id);
    }

    @GetMapping(
            value = "/getAll",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<PersonVO> getFindAll() {
        return personService.findAll();
    }

    /*
        Consumes vai fazer semelhante ao Produces, mas agora eh o que ele espera de ENTRADA, no body da requisicao
        Neste caso ele espera um json do tipo Person
     */
    @PostMapping(
            value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonVO postCreatePerson(
            @RequestBody PersonVO personVO
    ) {
        return personService.create(personVO);
    }

    @PostMapping(
            value = "/v2/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonVOV2 postCreatePersonV2(
            @RequestBody PersonVOV2 personVOV2
    ) {
        return personService.createV2(personVOV2);
    }

    @PutMapping(
            value = "/update",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public PersonVO putUpdatesPerson(
            @RequestBody PersonVO personVO
    ) {
        return personService.update(personVO);
    }

    @DeleteMapping(
            value = "/delete/{id}"
    )
    public ResponseEntity<?> deletePersonById(
            @PathVariable Long id
    ) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
