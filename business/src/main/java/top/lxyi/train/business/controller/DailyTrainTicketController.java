package top.lxyi.train.business.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lxyi.train.business.req.DailyTrainTicketQueryReq;
import top.lxyi.train.business.resp.DailyTrainTicketQueryResp;
import top.lxyi.train.business.resp.StationQueryResp;
import top.lxyi.train.business.service.DailyTrainTicketService;
import top.lxyi.train.business.service.StationService;
import top.lxyi.train.common.resp.CommonResp;
import top.lxyi.train.common.resp.PageResp;

import java.util.List;

@RestController
@RequestMapping("/daily-train-ticket")
public class DailyTrainTicketController {
    @Resource
    private DailyTrainTicketService dailyTrainTicketService;
    @GetMapping("/query-list")
    public CommonResp<PageResp<DailyTrainTicketQueryResp>> queryList(@Valid DailyTrainTicketQueryReq req){
        PageResp<DailyTrainTicketQueryResp> list = dailyTrainTicketService.queryList(req);
        return new CommonResp<>(list);
    }
}
