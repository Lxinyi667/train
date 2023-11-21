package top.lxyi.train.member.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.lxyi.train.common.context.LoginMemberContext;
import top.lxyi.train.common.resp.PageResp;
import top.lxyi.train.common.util.SnowUtil;
import top.lxyi.train.member.domain.Passenger;
import top.lxyi.train.member.domain.PassengerExample;
import top.lxyi.train.member.mapper.PassengerMapper;
import top.lxyi.train.member.req.PassengerQueryReq;
import top.lxyi.train.member.req.PassengerSaveReq;
import top.lxyi.train.member.resp.PassengerQueryResp;

import java.util.List;

@Service
@Slf4j
public class PassengerService {
    @Resource
    private PassengerMapper passengerMapper;
    public void save(PassengerSaveReq req) {
        DateTime now = DateTime.now();
        Passenger passenger = BeanUtil.copyProperties(req, Passenger.class);
        passenger.setMemberId(LoginMemberContext.getId());
        passenger.setId(SnowUtil.getSnowflakeNextId());
        passenger.setCreateTime(now);
        passenger.setUpdateTime(now);
        passengerMapper.insert(passenger);
    }

    public PageResp<PassengerQueryResp> queryList(PassengerQueryReq req) {
        PassengerExample passengerExample = new PassengerExample();
        passengerExample.setOrderByClause("id desc");
        PassengerExample.Criteria criteria = passengerExample.createCriteria();
        if (ObjectUtil.isNotNull(req.getMemberId())) {
            criteria.andMemberIdEqualTo(req.getMemberId());
        }

        log.info("查询页码：{}",req.getPage());
        log.info("每页条数：{}",req.getSize());
        PageHelper.startPage(req.getPage(),req.getSize());
        List<Passenger> passengerList = passengerMapper.selectByExample(passengerExample);

        PageInfo<Passenger> pageInfo =new PageInfo<>(passengerList);
        log.info("总行数：{}", pageInfo.getTotal());
        log.info("总页数：{}", pageInfo.getPages());

        List<PassengerQueryResp> list = BeanUtil.copyToList(passengerList,PassengerQueryResp.class);

        PageResp<PassengerQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;

    }
}
