package top.lxyi.train.business.req;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import top.lxyi.train.common.req.PageReq;

import java.util.Date;

@Getter
@Setter
public class DailyTrainTicketQueryReq extends PageReq {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private String trainCode;
    private String start;
    private String end;
    @Override
    public String toString() {
        return "DailyTrainTicketQueryReq{" +
        "} " + super.toString();
    }
}