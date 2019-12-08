package mapper;

import java.util.HashMap;
import java.util.List;

public class Request {

    private String id;

    private HashMap<String, List<String>> params;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    HashMap<String, List<String>> getParams() {
        return params;
    }

    public void setParams(HashMap<String, List<String>> params) {
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