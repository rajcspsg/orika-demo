package mapper;

import java.util.List;
import java.util.Map;

public class ObjectB {

    private Long reqId;

    private Double cp;

    public Long getReqId() {
        return reqId;
    }

    public void setReqId(Long reqId) {
        this.reqId = reqId;
    }

    public Double getCp() {
        return cp;
    }

    public void setCp(Double cp) {
        this.cp = cp;
    }

    @Override
    public String toString() {
        return "ObjectB{" +
                "reqId=" + reqId +
                ", cp=" + cp +
                '}';
    }
}