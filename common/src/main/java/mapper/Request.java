package mapper;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import static java.util.Arrays.asList;
import java.util.AbstractMap.SimpleEntry;
import static java.util.stream.Collectors.toMap;

public class Request {

    private Map<String, List<String>> params = Stream.of(
            new SimpleEntry<String, List<String>>("id", asList("1")),
            new SimpleEntry<String, List<String>>("cp", asList("12.5")))
            .collect(toMap(SimpleEntry::getKey, SimpleEntry::getValue));

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    Map<String, List<String>> getParams() {
        return params;
    }

    public void setParams(Map<String, List<String>> params) {
        this.params = params;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}