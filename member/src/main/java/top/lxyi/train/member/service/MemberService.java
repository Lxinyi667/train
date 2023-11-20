package top.lxyi.train.member.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.lxyi.train.member.mapper.MemberMapper;

@Service
public class MemberService {
    @Resource
    private MemberMapper memberMapper;

    public int count(){
        return Math.toIntExact(memberMapper.countByExample(null));
    }
}
