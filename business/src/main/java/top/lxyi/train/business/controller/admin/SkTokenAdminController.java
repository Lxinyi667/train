package top.lxyi.train.business.controller.admin;

import top.lxyi.train.common.context.LoginMemberContext;
import top.lxyi.train.common.resp.CommonResp;
import top.lxyi.train.common.resp.PageResp;
import top.lxyi.train.business.req.SkTokenQueryReq;
import top.lxyi.train.business.req.SkTokenSaveReq;
import top.lxyi.train.business.resp.SkTokenQueryResp;
import top.lxyi.train.business.service.SkTokenService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/sk-token")
public class SkTokenAdminController {

@Resource
private SkTokenService skTokenService;

@PostMapping("/save")
public CommonResp<Object> save(@Valid @RequestBody SkTokenSaveReq req) {
    skTokenService.save(req);
    return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<SkTokenQueryResp>> queryList(@Valid SkTokenQueryReq req) {
        PageResp<SkTokenQueryResp> list = skTokenService.queryList(req);
            return new CommonResp<>(list);
            }

            @DeleteMapping("/delete/{id}")
            public CommonResp<Object> delete(@PathVariable Long id) {
                skTokenService.delete(id);
                return new CommonResp<>();
                }

                }