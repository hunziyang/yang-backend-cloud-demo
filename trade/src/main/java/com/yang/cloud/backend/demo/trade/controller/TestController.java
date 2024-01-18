package com.yang.cloud.backend.demo.trade.controller;

import com.yang.cloud.backend.demo.common.result.Result;
import com.yang.cloud.backend.demo.trade.feign.StockFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private StockFeignService stockFeignService;

    @GetMapping("/test")
    public Result test(@RequestParam Integer num){
        System.out.println(stockFeignService.test(num));
        return Result.success();
    }
}
