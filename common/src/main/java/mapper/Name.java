package mapper;

public class Name {
    private String first;
    private String last;
    private String fullName;
    // getters/setters

    public Name() {

    }

    public Name(String first, String last, String fullName) {
        this.first = first;
        this.last = last;
        this.fullName = fullName;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
