package com.yang.cloud.backend.demo.trade.config;

import feign.Logger;
import feign.Request;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level level(){
        return Logger.Level.FULL;
    }

    @Bean
    public Request.Options options(){
        return new Request.Options(5000,5000);
    }

    @Bean
    public ErrorDecoder errorDecoder(){
        return new FeignErrorDecode();
    }
}
