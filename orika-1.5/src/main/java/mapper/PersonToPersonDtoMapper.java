package mapper;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;
import ma.glasnost.orika.metadata.Type;
import mapper.Person;
import mapper.PersonDto;

import java.util.Map;

public class PersonToPersonDtoMapper implements BoundMapperFacade<Person, PersonDto>  {

    BoundMapperFacade<Person, PersonDto> delegate;

    public PersonToPersonDtoMapper(Map<String, String> fieldMap) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).dumpStateOnException(false).build();
        ClassMapBuilder<Person, PersonDto> classBuilder = mapperFactory.classMap(Person.class, PersonDto.class);
        fieldMap.forEach((k,v) -> classBuilder.field(k,v));
        classBuilder.register();
        delegate = mapperFactory.getMapperFacade(Person.class, PersonDto.class);
    }

    @Override
    public PersonDto map(Person instanceA) {
        return delegate.map(instanceA);
    }

    @Override
    public PersonDto map(Person instanceA, MappingContext context) {
        return delegate.map(instanceA, context);
    }

    @Override
    public Person mapReverse(PersonDto instanceB) {
        return delegate.mapReverse(instanceB);
    }

    @Override
    public Person mapReverse(PersonDto instanceB, MappingContext context) {
        return delegate.mapReverse(instanceB, context);
    }

    @Override
    public PersonDto map(Person instanceA, PersonDto instanceB) {
        return  delegate.map(instanceA);
    }

    @Override
    public PersonDto map(Person instanceA, PersonDto instanceB, MappingContext context) {
        return  delegate.map(instanceA, context);
    }

    @Override
    public Person mapReverse(PersonDto instanceB, Person instanceA) {
        return delegate.mapReverse(instanceB, instanceA);
    }

    @Override
    public Person mapReverse(PersonDto instanceB, Person instanceA, MappingContext context) {
        return delegate.mapReverse(instanceB, instanceA, context);
    }

    @Override
    public PersonDto newObject(Person source, MappingContext context) {
        return delegate.newObject(source, context);
    }


    @Override
    public Person newObjectReverse(PersonDto source, MappingContext context) {
        return delegate.newObjectReverse(source, context);
    }

    @Override
    public Type<Person> getAType() {
        return delegate.getAType();
    }

    @Override
    public Type<PersonDto> getBType() {
        return delegate.getBType();
    }
}
