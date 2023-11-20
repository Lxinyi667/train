package top.lxyi.train.member.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.log.AbstractLog;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.lxyi.train.common.exception.BusinessException;
import top.lxyi.train.common.exception.BusinessExceptionEnum;
import top.lxyi.train.common.util.SnowUtil;
import top.lxyi.train.member.domain.Member;
import top.lxyi.train.member.domain.MemberExample;
import top.lxyi.train.member.mapper.MemberMapper;
import top.lxyi.train.member.req.MemberRegisterReq;
import top.lxyi.train.member.req.MemberSendCodeReq;

import java.util.List;



@Service
@Slf4j
public class MemberService {
    @Resource
    private MemberMapper memberMapper;

    public int count(){
        return Math.toIntExact(memberMapper.countByExample(null));
    }

//    public long register(String mobile) {
//        MemberExample memberExample = new MemberExample();
//        memberExample.createCriteria().andMobileEqualTo(mobile);
//        List<Member> list = memberMapper.selectByExample(memberExample);
//        if (CollUtil.isNotEmpty(list)) {
//            throw new RuntimeException("手机号已注册");
//        }
//        Member member = new Member();
//        member.setId(System.currentTimeMillis());
//        member.setMobile(mobile);
//        memberMapper.insert(member);
//        return member.getId();
//    }
    public long register(MemberRegisterReq req){
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);
        if (CollUtil.isNotEmpty(list)){
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }
        Member member = new Member();
//        member.setId(System.currentTimeMillis());
        member.setId(SnowUtil.getSnowflakeNextId());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }
    public void sendCode(MemberSendCodeReq req){
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> list = memberMapper.selectByExample(memberExample);
        //如果手机号不存则，啧插入一条记录
        if (CollUtil.isEmpty(list)){

            log.info("手机号不存在，插入一条记录");
            Member member =new Member();
            member.setId(SnowUtil.getSnowflakeNextId());
            member.setMobile(mobile);
            memberMapper.insert(member);

        } else {
            log.info("手机号存在，不插入记录");
        }
        //生成验证码
          //String code =RandomUtil.randomString(4);
        String code ="8888";
        log.info("生成短信验证码：{}",code);
//保存短信记录表：手机号，短信验证码，有效期，是否已使用，业务类型，发送时间，
        //使用时间
        log.info("保存短信记录表");
//对接短信通道，发送短信
        log.info("对接短信通道");
    }
}
