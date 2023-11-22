package top.lxyi.train.business.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.lxyi.train.business.domain.TrainSeat;
import top.lxyi.train.business.domain.TrainSeatExample;

public interface TrainSeatMapper {
    long countByExample(TrainSeatExample example);

    int deleteByExample(TrainSeatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TrainSeat row);

    int insertSelective(TrainSeat row);

    List<TrainSeat> selectByExample(TrainSeatExample example);

    TrainSeat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") TrainSeat row, @Param("example") TrainSeatExample example);

    int updateByExample(@Param("row") TrainSeat row, @Param("example") TrainSeatExample example);

    int updateByPrimaryKeySelective(TrainSeat row);

    int updateByPrimaryKey(TrainSeat row);
}