package com.yang.cloud.backend.demo.trade.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yang.cloud.backend.demo.common.exception.BaseException;
import com.yang.cloud.backend.demo.common.result.Result;
import com.yang.cloud.backend.demo.common.result.ResultCode;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class FeignErrorDecode implements ErrorDecoder {

    private static final ObjectMapper objectMapper = new JacksonConfig().objectMapper();

    @SneakyThrows
    @Override
    public Exception decode(String s, Response response) {
        try {
            Result result = objectMapper.readValue(response.body().asInputStream(), Result.class);
            return new BaseException(ResultCode.FEIGN_ERROR, result.getErrors());
        } catch (IOException e) {
            Exception exception = new ErrorDecoder.Default().decode(s, response);
            log.warn("feign decode err", exception);
            Map<String, String> errors = new HashMap<String, String>() {
                {
                    put("errors", exception.getMessage());
                }
            };
            return new BaseException(ResultCode.FEIGN_ERROR, errors);
        }
    }
}
