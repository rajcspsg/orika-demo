package mapper;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestIssue332 {

    @Test
    public void testIssue332() {
        Map<String, String> fieldMap = new HashMap<>();
        fieldMap.put("request.id", "reqId");
        fieldMap.put("request.params['cp'][0]", "cp");

        ObjectA a = new ObjectA();
        Request request = new Request();
        request.setId("123");
        a.setRequest(request);


        Map<String, List<String>> params = new HashMap<String, List<String>>();
        params.put("id", new ArrayList<String>() {{
            add("2");
        }});
        params.put("cp", new ArrayList<String>() {{
            add("0.51");
            add("0.52");
            add("0.53");
        }});
        request.setParams(params);


        MappingContext.Factory mcf = new MappingContext.Factory();
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).mappingContextFactory(mcf).dumpStateOnException(false).build();
        ClassMapBuilder<ObjectA, ObjectB> impBuilder = mapperFactory.classMap(ObjectA.class, ObjectB.class);
        fieldMap.forEach((k, v) -> impBuilder.field(k, v));
        impBuilder.register();

        BoundMapperFacade<ObjectA, ObjectB> delegate = mapperFactory.getMapperFacade(ObjectA.class, ObjectB.class);

        ObjectB b = delegate.map(a);
        System.out.println(b);
    }

}
