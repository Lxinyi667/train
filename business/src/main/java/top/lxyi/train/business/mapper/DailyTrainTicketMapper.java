package top.lxyi.train.business.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.lxyi.train.business.domain.DailyTrainTicket;
import top.lxyi.train.business.domain.DailyTrainTicketExample;

public interface DailyTrainTicketMapper {
    long countByExample(DailyTrainTicketExample example);

    int deleteByExample(DailyTrainTicketExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DailyTrainTicket row);

    int insertSelective(DailyTrainTicket row);

    List<DailyTrainTicket> selectByExample(DailyTrainTicketExample example);

    DailyTrainTicket selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") DailyTrainTicket row, @Param("example") DailyTrainTicketExample example);

    int updateByExample(@Param("row") DailyTrainTicket row, @Param("example") DailyTrainTicketExample example);

    int updateByPrimaryKeySelective(DailyTrainTicket row);

    int updateByPrimaryKey(DailyTrainTicket row);
}