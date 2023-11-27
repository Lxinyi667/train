package top.lxyi.train.member.controller.admin;

import top.lxyi.train.common.context.LoginMemberContext;
import top.lxyi.train.common.req.MemberTicketReq;
import top.lxyi.train.common.resp.CommonResp;
import top.lxyi.train.common.resp.PageResp;
import top.lxyi.train.member.req.TicketQueryReq;
import top.lxyi.train.member.req.TicketSaveReq;
import top.lxyi.train.member.resp.TicketQueryResp;
import top.lxyi.train.member.service.TicketService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/ticket")
public class TicketAdminController {

    @Resource
    private TicketService ticketService;

    @GetMapping("/query-list")
    public CommonResp<PageResp<TicketQueryResp>> queryList(@Valid TicketQueryReq req) {
        PageResp<TicketQueryResp> list = ticketService.queryList(req);
        return new CommonResp<>(list);
    }

}