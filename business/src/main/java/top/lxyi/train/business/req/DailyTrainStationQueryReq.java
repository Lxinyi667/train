package top.lxyi.train.business.req;


import org.springframework.format.annotation.DateTimeFormat;
import top.lxyi.train.common.req.PageReq;

import java.util.Date;

public class DailyTrainStationQueryReq extends PageReq {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String trainCode;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }

    @Override
public String toString() {
return "DailyTrainStationQueryReq{" +
"} " + super.toString();
}
}