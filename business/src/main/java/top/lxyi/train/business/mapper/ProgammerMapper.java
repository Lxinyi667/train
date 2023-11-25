package top.lxyi.train.business.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import top.lxyi.train.business.domain.Progammer;
import top.lxyi.train.business.domain.ProgammerExample;

public interface ProgammerMapper {
    long countByExample(ProgammerExample example);

    int deleteByExample(ProgammerExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Progammer row);

    int insertSelective(Progammer row);

    List<Progammer> selectByExample(ProgammerExample example);

    Progammer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") Progammer row, @Param("example") ProgammerExample example);

    int updateByExample(@Param("row") Progammer row, @Param("example") ProgammerExample example);

    int updateByPrimaryKeySelective(Progammer row);

    int updateByPrimaryKey(Progammer row);
}