package top.lxyi.train.member.service;

import cn.hutool.core.collection.CollUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.lxyi.train.common.exception.BusinessException;
import top.lxyi.train.common.exception.BusinessExceptionEnum;
import top.lxyi.train.member.domain.Member;
import top.lxyi.train.member.domain.MemberExample;
import top.lxyi.train.member.mapper.MemberMapper;
import top.lxyi.train.member.req.MemberRegisterReq;

import java.util.List;

@Service
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
        member.setId(System.currentTimeMillis());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }
}
