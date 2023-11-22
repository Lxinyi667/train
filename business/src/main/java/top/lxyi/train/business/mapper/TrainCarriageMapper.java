package top.lxyi.train.business.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.lxyi.train.business.domain.TrainCarriage;
import top.lxyi.train.business.domain.TrainCarriageExample;

public interface TrainCarriageMapper {
    long countByExample(TrainCarriageExample example);

    int deleteByExample(TrainCarriageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TrainCarriage row);

    int insertSelective(TrainCarriage row);

    List<TrainCarriage> selectByExample(TrainCarriageExample example);

    TrainCarriage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") TrainCarriage row, @Param("example") TrainCarriageExample example);

    int updateByExample(@Param("row") TrainCarriage row, @Param("example") TrainCarriageExample example);

    int updateByPrimaryKeySelective(TrainCarriage row);

    int updateByPrimaryKey(TrainCarriage row);
}