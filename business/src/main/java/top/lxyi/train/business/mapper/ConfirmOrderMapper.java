package top.lxyi.train.business.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.lxyi.train.business.domain.ConfirmOrder;
import top.lxyi.train.business.domain.ConfirmOrderExample;

public interface ConfirmOrderMapper {
    long countByExample(ConfirmOrderExample example);

    int deleteByExample(ConfirmOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ConfirmOrder row);

    int insertSelective(ConfirmOrder row);

    List<ConfirmOrder> selectByExampleWithBLOBs(ConfirmOrderExample example);

    List<ConfirmOrder> selectByExample(ConfirmOrderExample example);

    ConfirmOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") ConfirmOrder row, @Param("example") ConfirmOrderExample example);

    int updateByExampleWithBLOBs(@Param("row") ConfirmOrder row, @Param("example") ConfirmOrderExample example);

    int updateByExample(@Param("row") ConfirmOrder row, @Param("example") ConfirmOrderExample example);

    int updateByPrimaryKeySelective(ConfirmOrder row);

    int updateByPrimaryKeyWithBLOBs(ConfirmOrder row);

    int updateByPrimaryKey(ConfirmOrder row);
}