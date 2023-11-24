package top.lxyi.train.business.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.lxyi.train.business.enums.SeatColEnum;
import top.lxyi.train.common.resp.PageResp;
import top.lxyi.train.common.util.SnowUtil;
import top.lxyi.train.business.domain.DailyTrainCarriage;
import top.lxyi.train.business.domain.DailyTrainCarriageExample;
import top.lxyi.train.business.mapper.DailyTrainCarriageMapper;
import top.lxyi.train.business.req.DailyTrainCarriageQueryReq;
import top.lxyi.train.business.req.DailyTrainCarriageSaveReq;
import top.lxyi.train.business.resp.DailyTrainCarriageQueryResp;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyTrainCarriageService {

private static final Logger LOG = LoggerFactory.getLogger(DailyTrainCarriageService.class);

@Resource
private DailyTrainCarriageMapper dailyTrainCarriageMapper;

public void save(DailyTrainCarriageSaveReq req) {
    DateTime now = DateTime.now();

    //自动计算出列数和座位数
    List<SeatColEnum> seatColEnums = SeatColEnum.getColsByType(req.getSeatType());
    req.setColCount(seatColEnums.size());
    req.setSeatCount(req.getColCount() * req.getRowCount());

    DailyTrainCarriage dailyTrainCarriage = BeanUtil.copyProperties(req, DailyTrainCarriage.class);
    if (ObjectUtil.isNull(dailyTrainCarriage.getId())) {
        dailyTrainCarriage.setId(SnowUtil.getSnowflakeNextId());
        dailyTrainCarriage.setCreateTime(now);
        dailyTrainCarriage.setUpdateTime(now);
        dailyTrainCarriageMapper.insert(dailyTrainCarriage);
    } else {
        dailyTrainCarriage.setUpdateTime(now);
        dailyTrainCarriageMapper.updateByPrimaryKey(dailyTrainCarriage);
    }
}

public PageResp<DailyTrainCarriageQueryResp> queryList(DailyTrainCarriageQueryReq req) {
    DailyTrainCarriageExample dailyTrainCarriageExample = new DailyTrainCarriageExample();
    dailyTrainCarriageExample.setOrderByClause("date desc,train_code asc");
    DailyTrainCarriageExample.Criteria criteria = dailyTrainCarriageExample.createCriteria();
    if (ObjectUtil.isNotNull(req.getDate())){
        criteria.andDateEqualTo(req.getDate());
    }
    if (ObjectUtil.isNotEmpty(req.getTrainCode())){
        criteria.andTrainCodeEqualTo(req.getTrainCode());
    }
    LOG.info("查询页码：{}", req.getPage());
    LOG.info("每页条数：{}", req.getSize());
    PageHelper.startPage(req.getPage(), req.getSize());
    List<DailyTrainCarriage> dailyTrainCarriageList = dailyTrainCarriageMapper.selectByExample(dailyTrainCarriageExample);

    PageInfo<DailyTrainCarriage> pageInfo = new PageInfo<>(dailyTrainCarriageList);
    LOG.info("总行数：{}", pageInfo.getTotal());
    LOG.info("总页数：{}", pageInfo.getPages());

    List<DailyTrainCarriageQueryResp> list = BeanUtil.copyToList(dailyTrainCarriageList, DailyTrainCarriageQueryResp.class);

        PageResp<DailyTrainCarriageQueryResp> pageResp = new PageResp<>();
            pageResp.setTotal(pageInfo.getTotal());
            pageResp.setList(list);
            return pageResp;
            }

            public void delete(Long id) {
            dailyTrainCarriageMapper.deleteByPrimaryKey(id);
            }

            }