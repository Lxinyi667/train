package top.lxyi.train.business.controller;

import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lxyi.train.business.req.SeatSellReq;
import top.lxyi.train.business.resp.SeatSellResp;
import top.lxyi.train.business.service.DailyTrainSeatService;
import top.lxyi.train.common.resp.CommonResp;

import java.util.List;

@RestController
@RequestMapping("/seat-sell")
public class SeatSellController {

    @Resource
    private DailyTrainSeatService dailyTrainSeatService;

    @GetMapping("/query")
    public CommonResp<List<SeatSellResp>> query(@Valid SeatSellReq req) {
        List<SeatSellResp> seatList = dailyTrainSeatService.querySeatSell(req);
        return new CommonResp<>(seatList);
    }

}
