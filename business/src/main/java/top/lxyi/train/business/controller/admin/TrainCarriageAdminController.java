package top.lxyi.train.business.controller.admin;

import top.lxyi.train.common.context.LoginMemberContext;
import top.lxyi.train.common.resp.CommonResp;
import top.lxyi.train.common.resp.PageResp;
import top.lxyi.train.business.req.TrainCarriageQueryReq;
import top.lxyi.train.business.req.TrainCarriageSaveReq;
import top.lxyi.train.business.resp.TrainCarriageQueryResp;
import top.lxyi.train.business.service.TrainCarriageService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/train-carriage")
public class TrainCarriageAdminController {

@Resource
private TrainCarriageService trainCarriageService;

@PostMapping("/save")
public CommonResp<Object> save(@Valid @RequestBody TrainCarriageSaveReq req) {
    trainCarriageService.save(req);
    return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<TrainCarriageQueryResp>> queryList(@Valid TrainCarriageQueryReq req) {
        PageResp<TrainCarriageQueryResp> list = trainCarriageService.queryList(req);
            return new CommonResp<>(list);
            }

            @DeleteMapping("/delete/{id}")
            public CommonResp<Object> delete(@PathVariable Long id) {
                trainCarriageService.delete(id);
                return new CommonResp<>();
                }

                }