package top.lxyi.train.member.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.lxyi.train.member.domain.Passenger;
import top.lxyi.train.member.domain.PassengerExample;

public interface PassengerMapper {
    long countByExample(PassengerExample example);

    int deleteByExample(PassengerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Passenger row);

    int insertSelective(Passenger row);

    List<Passenger> selectByExample(PassengerExample example);

    Passenger selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") Passenger row, @Param("example") PassengerExample example);

    int updateByExample(@Param("row") Passenger row, @Param("example") PassengerExample example);

    int updateByPrimaryKeySelective(Passenger row);

    int updateByPrimaryKey(Passenger row);
}