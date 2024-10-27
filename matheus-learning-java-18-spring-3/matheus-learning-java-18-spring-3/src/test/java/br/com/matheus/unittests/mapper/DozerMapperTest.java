package br.com.matheus.unittests.mapper;

import br.com.matheus.spring.learning.matheuslearningjava18spring3.data.vo.v1.PersonVO;
import br.com.matheus.spring.learning.matheuslearningjava18spring3.mapper.DozerMapper;
import br.com.matheus.spring.learning.matheuslearningjava18spring3.models.Person;
import br.com.matheus.unittests.mapper.mocks.PersonMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class DozerMapperTest {

    PersonMock personMock;

    @Test
    public void parsePersonVOToPersonTest() {
        Person personOutput = DozerMapper.parseObject(this.personMock.personVOMock(), Person.class);
        Assertions.assertEquals("Matheus VO", personOutput.getFirstName());
        Assertions.assertEquals("Oliveira VO", personOutput.getLastName());
        Assertions.assertEquals("Tiradentes VO", personOutput.getAddress());
        Assertions.assertEquals("Male VO", personOutput.getGender());
    }

    @Test
    public void parsePersonToPersonVOTest() {
        PersonVO personVOOutput = DozerMapper.parseObject(personMock.personMock(), PersonVO.class);
        Assertions.assertEquals("Matheus", personVOOutput.getFirstName());
        Assertions.assertEquals("Oliveira", personVOOutput.getLastName());
        Assertions.assertEquals("Tiradentes", personVOOutput.getAddress());
        Assertions.assertEquals("Male", personVOOutput.getGender());
    }

    @Test
    public void parsePersonVOListToPersonListTest () {
        int actuallyIndex = 0;
        List<Person> personListOutput = DozerMapper.parseListObject(personMock.personVOListMock(5), Person.class);

        for (Person person : personListOutput) {
            actuallyIndex = actuallyIndex + 1;
            Assertions.assertEquals("Matheus VO" + actuallyIndex, person.getFirstName());
            Assertions.assertEquals("Oliveira VO" + actuallyIndex, person.getLastName());
            Assertions.assertEquals("Tiradentes VO" + actuallyIndex, person.getAddress());
            Assertions.assertEquals("Male VO" + actuallyIndex, person.getGender());
        }
    }

    @Test
    public void parsePersonListToPersonVOListTest () {
        int actuallyIndex = 0;

        List<PersonVO> personVOListOutput = DozerMapper.parseListObject(personMock.personListMock(5), PersonVO.class);
        
        for (PersonVO personVO : personVOListOutput) {
            actuallyIndex = actuallyIndex + 1;
            Assertions.assertEquals("Matheus" + actuallyIndex, personVO.getFirstName());
            Assertions.assertEquals("Oliveira" + actuallyIndex, personVO.getLastName());
            Assertions.assertEquals("Tiradentes" + actuallyIndex, personVO.getAddress());
            Assertions.assertEquals("Male" + actuallyIndex, personVO.getGender());
        }
    }
}
