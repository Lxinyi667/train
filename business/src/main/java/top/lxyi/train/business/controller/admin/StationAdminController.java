package top.lxyi.train.business.controller.admin;

import top.lxyi.train.business.resp.TrainQueryResp;
import top.lxyi.train.common.context.LoginMemberContext;
import top.lxyi.train.common.resp.CommonResp;
import top.lxyi.train.common.resp.PageResp;
import top.lxyi.train.business.req.StationQueryReq;
import top.lxyi.train.business.req.StationSaveReq;
import top.lxyi.train.business.resp.StationQueryResp;
import top.lxyi.train.business.service.StationService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/station")
public class StationAdminController {

@Resource
private StationService stationService;

@PostMapping("/save")
public CommonResp<Object> save(@Valid @RequestBody StationSaveReq req) {
    stationService.save(req);
    return new CommonResp<>();
    }
    @GetMapping("/query-all")
    public CommonResp<List<StationQueryResp>> queryList() {
        List<StationQueryResp> list = stationService.queryAll();
        return new CommonResp<>(list);
    }
    @GetMapping("/query-list")
    public CommonResp<PageResp<StationQueryResp>> queryList(@Valid StationQueryReq req) {
        PageResp<StationQueryResp> list = stationService.queryList(req);
            return new CommonResp<>(list);
            }

            @DeleteMapping("/delete/{id}")
            public CommonResp<Object> delete(@PathVariable Long id) {
                stationService.delete(id);
                return new CommonResp<>();
                }

                }