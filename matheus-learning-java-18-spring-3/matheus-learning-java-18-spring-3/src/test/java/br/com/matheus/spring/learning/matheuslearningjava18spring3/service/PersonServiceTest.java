package br.com.matheus.spring.learning.matheuslearningjava18spring3.service;

import br.com.matheus.spring.learning.matheuslearningjava18spring3.data.vo.v1.PersonVO;
import br.com.matheus.spring.learning.matheuslearningjava18spring3.data.vo.v2.PersonVOV2;
import br.com.matheus.spring.learning.matheuslearningjava18spring3.exceptions.RequiredObjectIsNullException;
import br.com.matheus.spring.learning.matheuslearningjava18spring3.mapper.custom.PersonMapper;
import br.com.matheus.spring.learning.matheuslearningjava18spring3.models.Person;
import br.com.matheus.spring.learning.matheuslearningjava18spring3.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/*
Por padrão o Junit 5 cria uma nova instancia da clase em toda a execução de metodo, ciclo de via por metodo (PER_METHOD)
Mas com essa anotação alteramos para fazer o ciclo de vida ser baseado na classe, fazendo a classe ser
instanciada apenas uma vez e sendo reutilizada em todos os metodos
*/
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)

// Injeta o Mockito no Junit 5
// @ExtendWith(MockitoExtension.class)

class PersonServiceTest {

    @InjectMocks
    private PersonService personService;
    @Mock
    private PersonRepository personRepository;
    @Mock
    private PersonMapper personMapper;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        Person person1 = getPerson();

        when(personRepository.findById(1L)).thenReturn(Optional.of(person1));

        PersonVO personVO = personService.findById(1L);

        assertNotNull(personVO);
        assertEquals(1L, personVO.getKey());
        assertEquals("Tirandentes", personVO.getAddress());
        assertEquals("Matheus", personVO.getFirstName());
        assertEquals("Oliveira", personVO.getLastName());
        assertEquals("Male", personVO.getGender());
        assertEquals("links: [</api/v1/person/1>;rel=\"self\"]", personVO.toString());

    }

    @Test
    void testFindAll() {
        List<Person> personList = getPeople();

        when(personRepository.findAll()).thenReturn(personList);

        List<PersonVO> personVOList = personService.findAll();

        assertNotNull(personVOList);
        assertEquals(2, personVOList.size());
        assertEquals("Tirandentes", personVOList.get(0).getAddress());
        assertEquals("Matheus", personVOList.get(0).getFirstName());
        assertEquals("Oliveira", personVOList.get(0).getLastName());
        assertEquals("Male", personVOList.get(0).getGender());
        assertEquals("links: [</api/v1/person/1>;rel=\"self\"]", personVOList.get(0).toString());
    }

    @Test
    void testCreate() {
        when(personRepository.save(getPerson())).thenReturn(getPerson());

        Person person = personRepository.save(getPerson());

        assertNotNull(person);
        assertEquals("Tirandentes", person.getAddress());
        assertEquals("Matheus", person.getFirstName());
        assertEquals("Oliveira", person.getLastName());
        assertEquals("Male", person.getGender());
    }

    @Test
    void testCreateRequiredObjectIsNullException() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            personService.create(null);
        });

        String expectedMessage = "It is no possible to persists a null object.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testCreateV2() {
        when(personMapper.convertPersonVOV2ToPerson(getPersonVOV2())).thenReturn(getPerson());

        when(personMapper.convertPersonToPersonVOV2(getPerson())).thenReturn(getPersonVOV2());

        PersonVOV2 personVOV2 = personMapper.convertPersonToPersonVOV2(getPerson());

        assertNotNull(personVOV2);
        assertEquals("Tirandentes", personVOV2.getAddress());
        assertEquals("Matheus", personVOV2.getFirstName());
        assertEquals("Oliveira", personVOV2.getLastName());
        assertEquals("Male", personVOV2.getGender());
        assertEquals(new Date().toString(), personVOV2.getBirthDay().toString());
    }

    @Test
    void testDelete() {

        Person person = getPerson();
        when(personRepository.findById(1L)).thenReturn(Optional.of(person));

        personRepository.delete(person);

        verify(personRepository, times(1)).delete(person);
    }

    @Test
    void testUpdate() {
        when(personRepository.findById(getPersonVO().getKey())).thenReturn(Optional.of(getPerson()));

        when(personRepository.save(getPerson())).thenReturn(getPerson());

        PersonVO personVO = getPersonVO();

        assertNotNull(personVO);
        assertEquals("Tirandentes", personVO.getAddress());
        assertEquals("Matheus", personVO.getFirstName());
        assertEquals("Oliveira", personVO.getLastName());
        assertEquals("Male", personVO.getGender());
    }

    @Test
    void testUpdateRequiredObjectIsNullException() {
        Exception exception = assertThrows(RequiredObjectIsNullException.class, () -> {
            personService.update(null);
        });

        String expectedMessage = "It is no possible to persists a null object.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    private static List<Person> getPeople() {
        Person person1 = new Person();
        person1.setId(1L);
        person1.setAddress("Tirandentes");
        person1.setFirstName("Matheus");
        person1.setLastName("Oliveira");
        person1.setGender("Male");

        Person person2 = new Person();
        person2.setId(1L);
        person2.setAddress("Tirandentes2");
        person2.setFirstName("Matheus2");
        person2.setLastName("Oliveira2");
        person2.setGender("Male");

        List<Person> personList = new ArrayList<>();

        personList.add(person1);
        personList.add(person2);
        return personList;
    }

    private static Person getPerson() {
        Person person1 = new Person();
        person1.setId(1L);
        person1.setAddress("Tirandentes");
        person1.setFirstName("Matheus");
        person1.setLastName("Oliveira");
        person1.setGender("Male");
        return person1;
    }

    private static PersonVOV2 getPersonVOV2() {
        PersonVOV2 personVOV2 = new PersonVOV2();
        personVOV2.setId(1L);
        personVOV2.setAddress("Tirandentes");
        personVOV2.setFirstName("Matheus");
        personVOV2.setLastName("Oliveira");
        personVOV2.setGender("Male");
        personVOV2.setBirthDay(new Date());
        return personVOV2;
    }

    private static PersonVO getPersonVO() {
        PersonVO personVO = new PersonVO();
        personVO.setKey(1L);
        personVO.setAddress("Tirandentes");
        personVO.setFirstName("Matheus");
        personVO.setLastName("Oliveira");
        personVO.setGender("Male");
        return personVO;
    }
}