package mapper;

import ma.glasnost.orika.BoundMapperFacade;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;

public class MapperTest {
    private BoundMapperFacade<ObjectA, ObjectB> mapper;

    @BeforeClass
    public void setUpBeforeClass() {
        Map<String,String> fieldMap = new HashMap<>();
        fieldMap.put("request.id","reqId");
        fieldMap.put("request.params","qs");
        //fieldMap.put("request.params['id']{}","evType");
        //fieldMap.put("request.params['cp']{}", "cp");
        String mapEntryFilter = "(X-.*)|(Accept-Language)";
        mapper = new ObjectAtoBMapper(fieldMap, mapEntryFilter);
    }


    @Test
    public void test1() {
        ObjectA a = new ObjectA();
        Request request = new Request();
        request.setId("123");
        a.setRequest(request);
        ObjectB b = mapper.map(a);
        //double cp = Double.parseDouble(a.getRequest().getParams().get("cp").get(1));
        //Assert.assertTrue(b.getCp().doubleValue() == cp);
        System.out.println(b);
    }
}
