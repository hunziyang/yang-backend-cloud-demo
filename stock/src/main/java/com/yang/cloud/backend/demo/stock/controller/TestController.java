package com.yang.cloud.backend.demo.stock.controller;

import com.yang.cloud.backend.demo.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test")
    public Result<String> test(@RequestParam("num") Integer num){
        if (num == 2){
            int i =1/0;
        }
        return Result.success("zzzz");
    }
}
