package top.lxyi.train.business.controller.admin;

import top.lxyi.train.common.context.LoginMemberContext;
import top.lxyi.train.common.resp.CommonResp;
import top.lxyi.train.common.resp.PageResp;
import top.lxyi.train.business.req.ProgammerQueryReq;
import top.lxyi.train.business.req.ProgammerSaveReq;
import top.lxyi.train.business.resp.ProgammerQueryResp;
import top.lxyi.train.business.service.ProgammerService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/progammer")
public class ProgammerAdminController {

@Resource
private ProgammerService progammerService;

@PostMapping("/save")
public CommonResp<Object> save(@Valid @RequestBody ProgammerSaveReq req) {
    progammerService.save(req);
    return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<ProgammerQueryResp>> queryList(@Valid ProgammerQueryReq req) {
        PageResp<ProgammerQueryResp> list = progammerService.queryList(req);
            return new CommonResp<>(list);
            }

            @DeleteMapping("/delete/{id}")
            public CommonResp<Object> delete(@PathVariable Long id) {
                progammerService.delete(id);
                return new CommonResp<>();
                }

                }