package top.lxyi.train.business.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.lxyi.train.common.resp.PageResp;
import top.lxyi.train.common.util.SnowUtil;
import top.lxyi.train.business.domain.DailyTrainStation;
import top.lxyi.train.business.domain.DailyTrainStationExample;
import top.lxyi.train.business.mapper.DailyTrainStationMapper;
import top.lxyi.train.business.req.DailyTrainStationQueryReq;
import top.lxyi.train.business.req.DailyTrainStationSaveReq;
import top.lxyi.train.business.resp.DailyTrainStationQueryResp;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyTrainStationService {

private static final Logger LOG = LoggerFactory.getLogger(DailyTrainStationService.class);

@Resource
private DailyTrainStationMapper dailyTrainStationMapper;

public void save(DailyTrainStationSaveReq req) {
DateTime now = DateTime.now();
DailyTrainStation dailyTrainStation = BeanUtil.copyProperties(req, DailyTrainStation.class);
if (ObjectUtil.isNull(dailyTrainStation.getId())) {
dailyTrainStation.setId(SnowUtil.getSnowflakeNextId());
dailyTrainStation.setCreateTime(now);
dailyTrainStation.setUpdateTime(now);
dailyTrainStationMapper.insert(dailyTrainStation);
} else {
dailyTrainStation.setUpdateTime(now);
dailyTrainStationMapper.updateByPrimaryKey(dailyTrainStation);
}
}

public PageResp<DailyTrainStationQueryResp> queryList(DailyTrainStationQueryReq req) {
    DailyTrainStationExample dailyTrainStationExample = new DailyTrainStationExample();
    dailyTrainStationExample.setOrderByClause("data desc,trainCode asc");
    DailyTrainStationExample.Criteria criteria = dailyTrainStationExample.createCriteria();
    if (ObjectUtil.isNotNull(req.getDate())){
        criteria.andDateEqualTo(req.getDate());
    }if (ObjectUtil.isNotEmpty(req.getTrainCode())){
        criteria.andTrainCodeEqualTo(req.getTrainCode());
    }
    LOG.info("查询页码：{}", req.getPage());
    LOG.info("每页条数：{}", req.getSize());
    PageHelper.startPage(req.getPage(), req.getSize());
    List<DailyTrainStation> dailyTrainStationList = dailyTrainStationMapper.selectByExample(dailyTrainStationExample);

    PageInfo<DailyTrainStation> pageInfo = new PageInfo<>(dailyTrainStationList);
    LOG.info("总行数：{}", pageInfo.getTotal());
    LOG.info("总页数：{}", pageInfo.getPages());

    List<DailyTrainStationQueryResp> list = BeanUtil.copyToList(dailyTrainStationList, DailyTrainStationQueryResp.class);

        PageResp<DailyTrainStationQueryResp> pageResp = new PageResp<>();
            pageResp.setTotal(pageInfo.getTotal());
            pageResp.setList(list);
            return pageResp;
            }

            public void delete(Long id) {
            dailyTrainStationMapper.deleteByPrimaryKey(id);
            }

            }