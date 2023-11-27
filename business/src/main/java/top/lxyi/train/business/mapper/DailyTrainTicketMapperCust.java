package top.lxyi.train.business.mapper;

import java.util.Date;

public interface DailyTrainTicketMapperCust {
    void updateCountBySell(Date date
            , String trainCode
            , String seatTypeCode
            , Integer minStartIndex
            , Integer maxStartIndex
            , Integer minEndIndex
            , Integer maxEndIndex);
}
