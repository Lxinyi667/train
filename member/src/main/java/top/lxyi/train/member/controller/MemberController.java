package top.lxyi.train.member.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lxyi.train.common.resp.CommonResp;
import top.lxyi.train.member.req.MemberRegisterReq;
import top.lxyi.train.member.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource
    private MemberService memberService;

    @GetMapping("/count")
    public Integer count() {
        return memberService.count();
    }

    @PostMapping("/register")
//    public long register(String mobile){
//        return memberService.register(mobile);
//    }
    public CommonResp<Long> register(@Valid MemberRegisterReq req){
        long register = memberService.register(req);
        return new CommonResp<>(register);
    }
}
