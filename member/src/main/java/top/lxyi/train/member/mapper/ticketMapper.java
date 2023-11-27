package top.lxyi.train.member.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.lxyi.train.member.domain.ticket;
import top.lxyi.train.member.domain.ticketExample;

public interface ticketMapper {
    long countByExample(ticketExample example);

    int deleteByExample(ticketExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ticket row);

    int insertSelective(ticket row);

    List<ticket> selectByExample(ticketExample example);

    ticket selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") ticket row, @Param("example") ticketExample example);

    int updateByExample(@Param("row") ticket row, @Param("example") ticketExample example);

    int updateByPrimaryKeySelective(ticket row);

    int updateByPrimaryKey(ticket row);
}