package top.lxyi.train.batch.controller;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.lxyi.train.batch.feign.BusinessFeign;

@RestController
@Slf4j
public class TestController {
    @Resource
    private BusinessFeign businessFeign;

    @GetMapping("/hello")
    public String hello() {
        String businessHello = businessFeign.getHello();
        log.info("businessHello:{}", businessHello);
        return "Hello World！Batch！";
    }
}
