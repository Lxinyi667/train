package top.lxyi.train.business.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.lxyi.train.common.resp.PageResp;
import top.lxyi.train.common.util.SnowUtil;
import top.lxyi.train.business.domain.TrainSeat;
import top.lxyi.train.business.domain.TrainSeatExample;
import top.lxyi.train.business.mapper.TrainSeatMapper;
import top.lxyi.train.business.req.TrainSeatQueryReq;
import top.lxyi.train.business.req.TrainSeatSaveReq;
import top.lxyi.train.business.resp.TrainSeatQueryResp;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainSeatService {

private static final Logger LOG = LoggerFactory.getLogger(TrainSeatService.class);

@Resource
private TrainSeatMapper trainSeatMapper;

public void save(TrainSeatSaveReq req) {
DateTime now = DateTime.now();
TrainSeat trainSeat = BeanUtil.copyProperties(req, TrainSeat.class);
if (ObjectUtil.isNull(trainSeat.getId())) {
trainSeat.setId(SnowUtil.getSnowflakeNextId());
trainSeat.setCreateTime(now);
trainSeat.setUpdateTime(now);
trainSeatMapper.insert(trainSeat);
} else {
trainSeat.setUpdateTime(now);
trainSeatMapper.updateByPrimaryKey(trainSeat);
}
}

public PageResp<TrainSeatQueryResp> queryList(TrainSeatQueryReq req) {
    TrainSeatExample trainSeatExample = new TrainSeatExample();
    trainSeatExample.setOrderByClause("train_code asc,'index' asc");
    TrainSeatExample.Criteria criteria = trainSeatExample.createCriteria();

    if (ObjectUtil.isNotEmpty(req.getTrainCode())) {
        criteria.andTrainCodeEqualTo(req.getTrainCode());
    }
    LOG.info("查询页码：{}", req.getPage());
    LOG.info("每页条数：{}", req.getSize());
    PageHelper.startPage(req.getPage(), req.getSize());
    List<TrainSeat> trainSeatList = trainSeatMapper.selectByExample(trainSeatExample);

    PageInfo<TrainSeat> pageInfo = new PageInfo<>(trainSeatList);
    LOG.info("总行数：{}", pageInfo.getTotal());
    LOG.info("总页数：{}", pageInfo.getPages());

    List<TrainSeatQueryResp> list = BeanUtil.copyToList(trainSeatList, TrainSeatQueryResp.class);

        PageResp<TrainSeatQueryResp> pageResp = new PageResp<>();
            pageResp.setTotal(pageInfo.getTotal());
            pageResp.setList(list);
            return pageResp;
            }

            public void delete(Long id) {
            trainSeatMapper.deleteByPrimaryKey(id);
            }

            }