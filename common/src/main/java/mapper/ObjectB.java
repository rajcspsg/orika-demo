package mapper;

import java.util.List;
import java.util.Map;

public class ObjectB {

    private int evType;
    private Double cp;
    private Long reqId;
    public Map<String, List<String>> qs;

    public int getEvType() {
        return evType;
    }

    public void setEvType(int evType) {
        this.evType = evType;
    }

    public Double getCp() {
        return cp;
    }

    public void setCp(Double cp) {
        this.cp = cp;
    }

    public void setEvType(Integer evType) {
        this.evType = evType;
    }

    public Map<String, List<String>> getQs() {
        return qs;
    }

    public void setQs(Map<String, List<String>> qs) {
        this.qs = qs;
    }

    public Long getReqId() {
        return reqId;
    }

    public void setReqId(Long reqId) {
        this.reqId = reqId;
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
