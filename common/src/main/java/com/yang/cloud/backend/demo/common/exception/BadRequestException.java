package com.yang.cloud.backend.demo.common.exception;


import com.yang.cloud.backend.demo.common.result.ResultCode;

import java.util.Map;

public class BadRequestException extends BaseException {


    public BadRequestException() {
        super(ResultCode.BAD_REQUEST);
    }

    public BadRequestException(Map<String, ?> errors) {
        super(ResultCode.BAD_REQUEST, errors);
    }
}
