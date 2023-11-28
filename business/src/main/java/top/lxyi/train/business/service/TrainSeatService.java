package top.lxyi.train.business.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;
import top.lxyi.train.business.domain.TrainCarriage;
import top.lxyi.train.business.domain.TrainExample;
import top.lxyi.train.business.enums.SeatColEnum;
import top.lxyi.train.business.mapper.TrainCarriageMapper;
import top.lxyi.train.business.mapper.TrainMapper;
import top.lxyi.train.common.exception.BusinessException;
import top.lxyi.train.common.exception.BusinessExceptionEnum;
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
    @Resource
    private TrainMapper trainMapper;
    @Resource
    private TrainCarriageService trainCarriageService;

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

    //添加方法，按车次编号查询所有座位
    public List<TrainSeat> selectByTrainCode(String trainCode) {
        TrainSeatExample trainSeatExample = new TrainSeatExample();
        trainSeatExample.setOrderByClause("'id' asc");
        trainSeatExample.createCriteria().andTrainCodeEqualTo(trainCode);
        return trainSeatMapper.selectByExample(trainSeatExample);
    }

    public PageResp<TrainSeatQueryResp> queryList(TrainSeatQueryReq req) {
        TrainSeatExample trainSeatExample = new TrainSeatExample();
        trainSeatExample.setOrderByClause("id desc");
        TrainSeatExample.Criteria criteria = trainSeatExample.createCriteria();

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

    @Transactional(rollbackFor = Exception.class)
    public void genTrainSeat(String trainCode) {
        // 判断车次是否存在
        TrainExample trainExample = new TrainExample();
        trainExample.createCriteria().andCodeEqualTo(trainCode);
        if (CollUtil.isEmpty(trainMapper.selectByExample(trainExample))) {
            throw new BusinessException(BusinessExceptionEnum.NONE);
        }
        DateTime now = DateTime.now();
        // 清空当前车次的座位信息
        TrainSeatExample trainSeatExample = new TrainSeatExample();
        trainSeatExample.createCriteria().andTrainCodeEqualTo(trainCode);
        trainSeatMapper.deleteByExample(trainSeatExample);
        // 查询当前车次的车厢信息
        List<TrainCarriage> carriageList = trainCarriageService.selectByTrainCode(trainCode);
        // 如果没有车厢信息，直接返回
        if (CollUtil.isEmpty(carriageList)) {
            throw new BusinessException(BusinessExceptionEnum.NONE);
        }
        // 循环生成每个车厢的座位
        for (TrainCarriage carriage : carriageList) {
            // 获取车厢数据
            Integer rowCount = carriage.getRowCount();
            String seatType = carriage.getSeatType();
            int seatIndex = 1;

            // 根据车厢座位类型，筛选出所有的列，比如一等座，筛选出columnList=[A,C,D,F]
            List<SeatColEnum> columns = SeatColEnum.getColsByType(seatType);
            // 循环行数
            for (int i = 1; i <= rowCount; i++) {
                // 循环列数
                for (SeatColEnum column : columns) {
                    TrainSeat trainSeat = new TrainSeat();
                    trainSeat.setId(SnowUtil.getSnowflakeNextId());
                    trainSeat.setTrainCode(trainCode);
                    trainSeat.setCarriageIndex(carriage.getIndex());
                    trainSeat.setCarriageSeatIndex(seatIndex++);
                    trainSeat.setSeatType(seatType);
                    trainSeat.setRow(StrUtil.fillBefore(String.valueOf(i), '0', 2));
                    trainSeat.setCol(column.getCode());
                    trainSeat.setCreateTime(now);
                    trainSeat.setUpdateTime(now);
                    trainSeatMapper.insert(trainSeat);
                }
            }
        }
    }
}