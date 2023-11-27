package top.lxyi.train.member.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import top.lxyi.train.common.resp.PageResp;
import top.lxyi.train.common.util.SnowUtil;
import top.lxyi.train.member.domain.ticket;
import top.lxyi.train.member.domain.ticketExample;
import top.lxyi.train.member.mapper.ticketMapper;
import top.lxyi.train.member.req.ticketQueryReq;
import top.lxyi.train.member.req.ticketSaveReq;
import top.lxyi.train.member.resp.ticketQueryResp;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ticketService {

private static final Logger LOG = LoggerFactory.getLogger(ticketService.class);

@Resource
private ticketMapper ticketMapper;

public void save(ticketSaveReq req) {
DateTime now = DateTime.now();
ticket ticket = BeanUtil.copyProperties(req, ticket.class);
if (ObjectUtil.isNull(ticket.getId())) {
ticket.setId(SnowUtil.getSnowflakeNextId());
ticket.setCreateTime(now);
ticket.setUpdateTime(now);
ticketMapper.insert(ticket);
} else {
ticket.setUpdateTime(now);
ticketMapper.updateByPrimaryKey(ticket);
}
}

public PageResp<ticketQueryResp> queryList(ticketQueryReq req) {
    ticketExample ticketExample = new ticketExample();
    ticketExample.setOrderByClause("id desc");
    ticketExample.Criteria criteria = ticketExample.createCriteria();

    LOG.info("查询页码：{}", req.getPage());
    LOG.info("每页条数：{}", req.getSize());
    PageHelper.startPage(req.getPage(), req.getSize());
    List<ticket> ticketList = ticketMapper.selectByExample(ticketExample);

    PageInfo<ticket> pageInfo = new PageInfo<>(ticketList);
    LOG.info("总行数：{}", pageInfo.getTotal());
    LOG.info("总页数：{}", pageInfo.getPages());

    List<ticketQueryResp> list = BeanUtil.copyToList(ticketList, ticketQueryResp.class);

        PageResp<ticketQueryResp> pageResp = new PageResp<>();
            pageResp.setTotal(pageInfo.getTotal());
            pageResp.setList(list);
            return pageResp;
            }

            public void delete(Long id) {
            ticketMapper.deleteByPrimaryKey(id);
            }

            }