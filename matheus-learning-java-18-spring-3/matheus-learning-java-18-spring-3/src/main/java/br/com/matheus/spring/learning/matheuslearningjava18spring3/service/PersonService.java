package br.com.matheus.spring.learning.matheuslearningjava18spring3.service;

import br.com.matheus.spring.learning.matheuslearningjava18spring3.controllers.PersonController;
import br.com.matheus.spring.learning.matheuslearningjava18spring3.data.vo.v1.PersonVO;
import br.com.matheus.spring.learning.matheuslearningjava18spring3.data.vo.v2.PersonVOV2;
import br.com.matheus.spring.learning.matheuslearningjava18spring3.exceptions.RequiredObjectIsNullException;
import br.com.matheus.spring.learning.matheuslearningjava18spring3.exceptions.ResourceNotFoundException;
import br.com.matheus.spring.learning.matheuslearningjava18spring3.mapper.DozerMapper;
import br.com.matheus.spring.learning.matheuslearningjava18spring3.mapper.custom.PersonMapper;
import br.com.matheus.spring.learning.matheuslearningjava18spring3.models.Person;
import br.com.matheus.spring.learning.matheuslearningjava18spring3.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/*
    A anotacao @Service serve para fazer com que sua classe se torne injetavel.
    Que basicamente eh ser instanciada em tempo de execucao
    Neste caso pelo spring
    Entao quando fizemos @Autowired nesta classe, o Spring sera responsavel por instancia-la em tempo de execucao

    O proposito aqui eh semantico, ou seja, quando eu estou usando um @repository,  eu estou falando de uma classe
    do tipo repository, quando eu estou falando do @Service, eu estou falando de uma classe do tipo service
    Mas todas sao @Component, sao apenas um alias

    Obs: Service eh um Alias para Component, que seria a class mae.
 */
@Service
public class PersonService {

    private final PersonRepository repository;
    private final PersonMapper personMapper;

    public PersonService(PersonRepository repository, PersonMapper personMapper) {
        this.repository = repository;
        this.personMapper = personMapper;
    }

    // private final AtomicLong counter = new AtomicLong();
    // Logs "personalizados" para cada classe
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public PersonVO findById(Long id) {
        logger.info("Finding one person!");

        Person person = repository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));

        PersonVO personVO = DozerMapper.parseObject(person, PersonVO.class);

        personVO.add(linkTo(methodOn(PersonController.class).getFindById(personVO.getKey())).withSelfRel());

        return personVO;
        // return getPersonMock();
    }

    public List<PersonVO> findAll() {
        logger.info("Returning all the people!");

        List<Person> personList = repository.findAll();

        List<PersonVO> personVOList = DozerMapper.parseListObject(personList, PersonVO.class);

        personVOList.stream().forEach(
                // Esta manipulando a instancia personVO
                // Metodo Add recebe o retorno de um objeto Link
                personVO -> personVO.add(
                                // Link eh retornado pelo metodo linkTo que vai adicionar um array com o nome "link" a instancia
                                linkTo(
                                // Method on, vai receber a controller e tambem o metodo chamado
                                methodOn(PersonController.class)
                                        // Com estes dois valores, ele consegue encontrar valor da URL
                                        // Ex: http://localhost:8080/j18s3/api/v1/person/22"
                                        .getFindById(personVO.getKey()))
                                // E aqui estou colocando mais um atributo dentro de "links" que marca que eh a chamada dele mesmo "self"
                                .withSelfRel())
        );

        return personVOList;
        // return getAllPeopleMock();
    }

    public PersonVO create(PersonVO personVO) {
        if (personVO == null) throw new RequiredObjectIsNullException();

        logger.info("Creating one person!");

        Person person = DozerMapper.parseObject(personVO, Person.class);

        PersonVO personVOConverted = DozerMapper.parseObject(repository.save(person), PersonVO.class);

        personVOConverted.add(linkTo(methodOn(PersonController.class).postCreatePerson(personVO)).withSelfRel());

        return personVOConverted;
        //return createPersonMock(person);
    }

    public PersonVOV2 createV2(PersonVOV2 personVOV2) {
        logger.info("Creating one person! V2");

        Person person = personMapper.convertPersonVOV2ToPerson(personVOV2);

        PersonVOV2 personVOV2Converted = personMapper.convertPersonToPersonVOV2(repository.save(person));

        // personVOV2Converted.add(linkTo(methodOn(PersonController.class).postCreatePersonV2(personVOV2)).withSelfRel());

        return personVOV2Converted;
    }

    public PersonVO update(PersonVO personVO) {
        if (personVO == null) throw new RequiredObjectIsNullException();

        logger.info("Updating one person!");

        Person entityPerson = repository.findById(personVO.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));

        entityPerson.setFirstName(personVO.getFirstName());
        entityPerson.setLastName(personVO.getLastName());
        entityPerson.setAddress(personVO.getAddress());
        entityPerson.setGender(personVO.getGender());

        PersonVO personVOConverted = DozerMapper.parseObject(repository.save(entityPerson), PersonVO.class);

        personVOConverted.add(linkTo(methodOn(PersonController.class).putUpdatesPerson(personVO)).withSelfRel());

        return personVOConverted;
        //return updatePersonMock(person);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found!"));

        repository.delete(entity);

        //return deletePersonByIdMock(id);
    }

    private Person getPersonMock() {
        Person person = new Person();
        //person.setId(counter.incrementAndGet());
        person.setFirstName("Matheus");
        person.setLastName("Silva");
        person.setAddress("Sao Paulo - Brazil");
        person.setGender("Male");
        return person;
    }

    private List<Person> getAllPeopleMock() {
        List<Person> people = new ArrayList<>();

        for (int i = 1; i < 9; i ++) {
            Person person = new Person();
            //person.setId(counter.incrementAndGet());
            person.setFirstName("First name " + i);
            person.setLastName("Last name " + i);
            person.setAddress("Address " + i);
            person.setGender("Any Gender " + i);

            people.add(person);
        }

        return people;
    }

    private Person createPersonMock(Person person) {
        return person;
    }

    private Person updatePersonMock(Person person) {
        return person;
    }

    private String deletePersonByIdMock(String id) {
        return "Deleted!";
    }
}
