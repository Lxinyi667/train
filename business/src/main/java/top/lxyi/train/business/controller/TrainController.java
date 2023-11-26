package top.lxyi.train.business.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lxyi.train.business.resp.TrainQueryResp;
import top.lxyi.train.business.service.TrainService;
import top.lxyi.train.common.resp.CommonResp;

import java.util.List;

@RestController
@RequestMapping("/train")
public class TrainController{
    @Resource
    private TrainService trainService;
    @GetMapping("/query-all")
    public CommonResp<List<TrainQueryResp>> queryList(){
        List<TrainQueryResp> list = trainService.queryAll();
        return new CommonResp<>(list);
    }
}
