package mapper;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import ma.glasnost.orika.metadata.Type;

import java.util.Map;

public class ObjectAtoBMapper implements BoundMapperFacade<ObjectA, ObjectB> {

    BoundMapperFacade<ObjectA, ObjectB> delegate;

    public ObjectAtoBMapper(Map<String, String> fieldMap, String mapEntryFilter) {
        init(fieldMap, mapEntryFilter);
    }

    public void init(Map<String, String> fieldMap, String mapEntryFilter) {
        MappingContext.Factory mcf = new MappingContext.Factory();
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).mappingContextFactory(mcf).dumpStateOnException(false).build();
        ClassMapBuilder<ObjectA, ObjectB> impBuilder = mapperFactory.classMap(ObjectA.class, ObjectB.class);
        fieldMap.forEach((k,v) -> impBuilder.field(k,v));
        impBuilder.register();

        try {
            delegate = mapperFactory.getMapperFacade(ObjectA.class, ObjectB.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public ObjectB map(ObjectA instanceA) {
        return delegate.map(instanceA);
    }

    @Override
    public ObjectB map(ObjectA instanceA, MappingContext context) {
        return delegate.map(instanceA, context);
    }

    @Override
    public ObjectA mapReverse(ObjectB instanceB) {
        return delegate.mapReverse(instanceB);
    }

    @Override
    public ObjectA mapReverse(ObjectB instanceB, MappingContext context) {
        return delegate.mapReverse(instanceB, context);
    }

    @Override
    public ObjectB map(ObjectA instanceA, ObjectB instanceB) {
        return  delegate.map(instanceA);
    }

    @Override
    public ObjectB map(ObjectA instanceA, ObjectB instanceB, MappingContext context) {
        return delegate.map(instanceA, instanceB);
    }

    @Override
    public ObjectA mapReverse(ObjectB instanceB, ObjectA instanceA) {
        return delegate.mapReverse(instanceB, instanceA);
    }

    @Override
    public ObjectA mapReverse(ObjectB instanceB, ObjectA instanceA, MappingContext context) {
        return delegate.mapReverse(instanceB, instanceA, context);
    }

    @Override
    public ObjectB newObject(ObjectA source, MappingContext context) {
        return delegate.newObject(source, context);
    }

    @Override
    public ObjectA newObjectReverse(ObjectB source, MappingContext context) {
        return delegate.newObjectReverse(source, context);
    }

    @Override
    public Type<ObjectA> getAType() {
        return delegate.getAType();
    }

    @Override
    public Type<ObjectB> getBType() {
        return delegate.getBType();
    }
}