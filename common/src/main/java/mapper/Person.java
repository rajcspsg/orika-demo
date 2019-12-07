package mapper;

import java.util.List;

public class Person {
    private List<Name> names;
    // getters/setters


    public Person() {
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }
}