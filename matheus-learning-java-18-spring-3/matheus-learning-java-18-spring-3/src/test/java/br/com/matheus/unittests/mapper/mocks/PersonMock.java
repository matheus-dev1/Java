package br.com.matheus.unittests.mapper.mocks;

import br.com.matheus.spring.learning.matheuslearningjava18spring3.data.vo.v1.PersonVO;
import br.com.matheus.spring.learning.matheuslearningjava18spring3.models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonMock {

    public static Person personMock (){
        Person person = new Person();
        person.setFirstName("Matheus");
        person.setLastName("Oliveira");
        person.setAddress("Tiradentes");
        person.setGender("Male");
        return person;
    }

    public static PersonVO personVOMock (){
        PersonVO personVO = new PersonVO();
        personVO.setFirstName("Matheus VO");
        personVO.setLastName("Oliveira VO");
        personVO.setAddress("Tiradentes VO");
        personVO.setGender("Male VO");
        return personVO;
    }

    public static List<Person> personListMock (int indexes) {
        List<Person> personList = new ArrayList<>();

        for (int i = 1; i < indexes; i++) {
            Person person = new Person();
            person.setFirstName("Matheus" + i);
            person.setLastName("Oliveira" + i);
            person.setAddress("Tiradentes" + i);
            person.setGender("Male" + i);
            personList.add(person);
        }

        return personList;
    }

    public static List<PersonVO> personVOListMock (int indexes) {
        List<PersonVO> personVOList = new ArrayList<>();

        for (int i = 1; i < indexes; i++) {
            PersonVO personVO = new PersonVO();
            personVO.setFirstName("Matheus VO" + i);
            personVO.setLastName("Oliveira VO" + i);
            personVO.setAddress("Tiradentes VO" + i);
            personVO.setGender("Male VO" + i);
            personVOList.add(personVO);
        }

        return personVOList;
    }
}
