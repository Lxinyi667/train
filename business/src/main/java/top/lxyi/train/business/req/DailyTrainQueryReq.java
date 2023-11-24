package top.lxyi.train.business.req;


import jakarta.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;
import top.lxyi.train.common.req.PageReq;

import java.util.Date;

public class DailyTrainQueryReq extends PageReq {
     private String code;
     @DateTimeFormat(pattern = "yyyy-MM-dd")
     private Date date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DailyTrainQueryReq{" +
        "} " + super.toString();
    }
}