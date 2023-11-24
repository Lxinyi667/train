package top.lxyi.train.business.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.lxyi.train.business.domain.DailyTrainStation;
import top.lxyi.train.business.domain.DailyTrainStationExample;

public interface DailyTrainStationMapper {
    long countByExample(DailyTrainStationExample example);

    int deleteByExample(DailyTrainStationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DailyTrainStation row);

    int insertSelective(DailyTrainStation row);

    List<DailyTrainStation> selectByExample(DailyTrainStationExample example);

    DailyTrainStation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") DailyTrainStation row, @Param("example") DailyTrainStationExample example);

    int updateByExample(@Param("row") DailyTrainStation row, @Param("example") DailyTrainStationExample example);

    int updateByPrimaryKeySelective(DailyTrainStation row);

    int updateByPrimaryKey(DailyTrainStation row);
}