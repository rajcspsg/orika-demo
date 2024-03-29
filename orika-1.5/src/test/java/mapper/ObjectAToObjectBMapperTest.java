package mapper;

import ma.glasnost.orika.BoundMapperFacade;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ObjectAToObjectBMapperTest {
    private BoundMapperFacade<ObjectA, ObjectB> mapper;

    @BeforeClass
    public void setUpBeforeClass() {
        Map<String,String> fieldMap = new HashMap<>();
        fieldMap.put("request.id","reqId");
        fieldMap.put("request.params['cp'][0]", "cp");
        mapper = new ObjectAtoBMapper(fieldMap);
    }


    @Test
    public void test1() {
        ObjectA a = new ObjectA();
        Request request = new Request();
        request.setId("123");
        a.setRequest(request);
        ObjectB b = mapper.map(a);
        System.out.println(b);
    }
}
