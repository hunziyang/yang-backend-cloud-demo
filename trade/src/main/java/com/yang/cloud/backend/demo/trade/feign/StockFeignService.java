package com.yang.cloud.backend.demo.trade.feign;

import com.yang.cloud.backend.demo.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "stock-service",path = "/stock-service/test")
public interface StockFeignService {

    @GetMapping("/test")
    Result<String> test(@RequestParam("num") Integer num);
}
