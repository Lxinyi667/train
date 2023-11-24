package top.lxyi.train.business.controller.admin;

import top.lxyi.train.common.context.LoginMemberContext;
import top.lxyi.train.common.resp.CommonResp;
import top.lxyi.train.common.resp.PageResp;
import top.lxyi.train.business.req.DailyTrainQueryReq;
import top.lxyi.train.business.req.DailyTrainSaveReq;
import top.lxyi.train.business.resp.DailyTrainQueryResp;
import top.lxyi.train.business.service.DailyTrainService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/daily-train")
public class DailyTrainAdminController {

@Resource
private DailyTrainService dailyTrainService;

@PostMapping("/save")
public CommonResp<Object> save(@Valid @RequestBody DailyTrainSaveReq req) {
    dailyTrainService.save(req);
    return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<DailyTrainQueryResp>> queryList(@Valid DailyTrainQueryReq req) {
        PageResp<DailyTrainQueryResp> list = dailyTrainService.queryList(req);
            return new CommonResp<>(list);
            }

            @DeleteMapping("/delete/{id}")
            public CommonResp<Object> delete(@PathVariable Long id) {
                dailyTrainService.delete(id);
                return new CommonResp<>();
                }

                }