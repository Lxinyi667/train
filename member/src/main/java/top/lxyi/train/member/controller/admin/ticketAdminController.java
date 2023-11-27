package top.lxyi.train.member.controller.admin;

import top.lxyi.train.common.context.LoginMemberContext;
import top.lxyi.train.common.resp.CommonResp;
import top.lxyi.train.common.resp.PageResp;
import top.lxyi.train.member.req.ticketQueryReq;
import top.lxyi.train.member.req.ticketSaveReq;
import top.lxyi.train.member.resp.ticketQueryResp;
import top.lxyi.train.member.service.ticketService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/ticket")
public class ticketAdminController {

@Resource
private ticketService ticketService;

@PostMapping("/save")
public CommonResp<Object> save(@Valid @RequestBody ticketSaveReq req) {
    ticketService.save(req);
    return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<ticketQueryResp>> queryList(@Valid ticketQueryReq req) {
        PageResp<ticketQueryResp> list = ticketService.queryList(req);
            return new CommonResp<>(list);
            }

            @DeleteMapping("/delete/{id}")
            public CommonResp<Object> delete(@PathVariable Long id) {
                ticketService.delete(id);
                return new CommonResp<>();
                }

                }