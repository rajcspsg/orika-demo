package mapper;

import ma.glasnost.orika.BoundMapperFacade;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PersonToPersonDtoMapperTest {

    private BoundMapperFacade<Person, PersonDto> mapper;

    @BeforeClass
    public void setUpBeforeClass() {
        Map<String,String> fieldMap = new HashMap<>();
        fieldMap.put("names{fullName}", "personalNames{key}");
        fieldMap.put("names{}", "personalNames{value}");
        mapper = new PersonToPersonDtoMapper(fieldMap);
    }

    @Test
    public void test1() {
        Person person = new Person();
        Name n1 = new Name("raj", "kumar", "raj kumar");
        Name n2 = new Name("senthil", "kumar", "senthil kumar");
        person.setNames(Arrays.asList(n1, n2));
        PersonDto pDto = mapper.map(person);
        System.out.println(pDto);
    }
}
