package top.lxyi.train.business.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.lxyi.train.business.domain.Train;
import top.lxyi.train.business.domain.TrainExample;

public interface TrainMapper {
    long countByExample(TrainExample example);

    int deleteByExample(TrainExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Train row);

    int insertSelective(Train row);

    List<Train> selectByExample(TrainExample example);

    Train selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") Train row, @Param("example") TrainExample example);

    int updateByExample(@Param("row") Train row, @Param("example") TrainExample example);

    int updateByPrimaryKeySelective(Train row);

    int updateByPrimaryKey(Train row);
}