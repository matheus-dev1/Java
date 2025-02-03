package br.com.matheus.spring.learning.matheuslearningjava18spring3.controllers;

import br.com.matheus.spring.learning.matheuslearningjava18spring3.data.vo.v1.PersonVO;
import br.com.matheus.spring.learning.matheuslearningjava18spring3.data.vo.v2.PersonVOV2;
import br.com.matheus.spring.learning.matheuslearningjava18spring3.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
@Tag(name = "People", description = "Endpoint for people management")
public class PersonController {

    private static final String MEDIA_TYPE_APPLICATION_YAML = "application/x-yaml";

    private final PersonService personService;

    public PersonController(PersonService personService){
        this.personService = personService;
    }

    /*
    * O parametro "produces" garante que o metodo/request que eu estou fazendo vai produzir/retornar o tipo especificado
    * Neste exemplo eu quero que o objeto Person seja retornado em formado json
    * */
    @GetMapping(
            value = "/{id}",
            // Mantendo estas linhas por conta do Swegger e XML
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MEDIA_TYPE_APPLICATION_YAML // String
            }
    )
    @Operation(
            summary = "Get person by Id",
            description = "Request to get person by id",
            // CTRL + ALT + Seta para baixo = Copia codigo para baixo
            tags = {
                    "People"
            },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonVO.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public PersonVO getFindById(
        @PathVariable(value = "id") Long id
    ) {
        return personService.findById(id);
    }

    @GetMapping(
            value = "/getAll",
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MEDIA_TYPE_APPLICATION_YAML
            }
    )
    @Operation(
            summary = "Get people",
            description = "Request to get all people",
            tags = {
                    "People"
            },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    // Lista de PersonVO = List<PersonVO>
                                    array = @ArraySchema(schema = @Schema(implementation = PersonVO.class))
                            )
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public List<PersonVO> getFindAll() {
        return personService.findAll();
    }

    /* Consumes vai fazer semelhante ao Produces, mas agora eh o que ele espera de ENTRADA, no body da requisicao
     * Neste caso ele espera um json do tipo Person
     */
    @PostMapping(
            value = "/create",
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MEDIA_TYPE_APPLICATION_YAML
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MEDIA_TYPE_APPLICATION_YAML
            }
    )
    @Operation(
            summary = "Create a person",
            description = "Create a person and return its value",
            tags = {
                    "People"
            },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonVO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public PersonVO postCreatePerson(
            @RequestBody PersonVO personVO
    ) {
        return personService.create(personVO);
    }

    @PostMapping(
            value = "/v2/create",
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MEDIA_TYPE_APPLICATION_YAML
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MEDIA_TYPE_APPLICATION_YAML
            }
    )
    @Operation(
            summary = "Create a person on PersonVOV2 model",
            description = "Create a person on PersonVOV2 model and return its value",
            tags = {
                    "People"
            },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonVOV2.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public PersonVOV2 postCreatePersonV2(
            @RequestBody PersonVOV2 personVOV2
    ) {
        return personService.createV2(personVOV2);
    }

    @PutMapping(
            value = "/update",
            consumes = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MEDIA_TYPE_APPLICATION_YAML
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MEDIA_TYPE_APPLICATION_YAML
            }
    )
    @Operation(
            summary = "Updates a person",
            description = "Updates a person and return its value",
            tags = {
                    "People"
            },
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonVO.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public PersonVO putUpdatesPerson(
            @RequestBody PersonVO personVO
    ) {
        return personService.update(personVO);
    }

    @DeleteMapping(
            value = "/delete/{id}"
    )
    @Operation(
            summary = "Deletes a person",
            description = "Deletes a person and return just the status code",
            tags = {
                    "People"
            },
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> deletePersonById(
            @PathVariable Long id
    ) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }
}