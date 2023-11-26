package top.lxyi.train.business.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lxyi.train.business.resp.StationQueryResp;
import top.lxyi.train.business.resp.TrainQueryResp;
import top.lxyi.train.business.service.StationService;
import top.lxyi.train.business.service.TrainService;
import top.lxyi.train.common.resp.CommonResp;

import java.util.List;

@RestController
@RequestMapping("/station")
public class StationController {
    @Resource
    private StationService stationService;
    @GetMapping("/query-all")
    public CommonResp<List<StationQueryResp>> queryList(){
        List<StationQueryResp> list = stationService.queryAll();
        return new CommonResp<>(list);
    }
}
