package top.lxyi.train.business.mapper;

import java.util.Date;

public interface SkTokenMapperCust {
    int decrease(Date date, String trainCode);
}