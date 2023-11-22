package top.lxyi.train.${module}.controller.admin;

import top.lxyi.train.common.context.LoginMemberContext;
import top.lxyi.train.common.resp.CommonResp;
import top.lxyi.train.common.resp.PageResp;
import top.lxyi.train.${module}.req.${Domain}QueryReq;
import top.lxyi.train.${module}.req.${Domain}SaveReq;
import top.lxyi.train.${module}.resp.${Domain}QueryResp;
import top.lxyi.train.${module}.service.${Domain}Service;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/${do_main}")
public class ${Domain}AdminController {

@Resource
private ${Domain}Service ${domain}Service;

@PostMapping("/save")
public CommonResp<Object> save(@Valid @RequestBody ${Domain}SaveReq req) {
    ${domain}Service.save(req);
    return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<${Domain}QueryResp>> queryList(@Valid ${Domain}QueryReq req) {
        PageResp<${Domain}QueryResp> list = ${domain}Service.queryList(req);
            return new CommonResp<>(list);
            }

            @DeleteMapping("/delete/{id}")
            public CommonResp<Object> delete(@PathVariable Long id) {
                ${domain}Service.delete(id);
                return new CommonResp<>();
                }

                }