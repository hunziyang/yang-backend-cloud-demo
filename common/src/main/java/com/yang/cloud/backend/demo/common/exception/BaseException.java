package com.yang.cloud.backend.demo.common.exception;

import com.yang.cloud.backend.demo.common.result.ResultCodeBase;
import lombok.Data;

import java.util.Map;

@Data
public class BaseException extends RuntimeException {

    private ResultCodeBase resultCodeBase;
    private Map<String, ?> errors;

    public BaseException(ResultCodeBase resultCodeBase) {
        super(resultCodeBase.getMsg());
        this.resultCodeBase = resultCodeBase;
    }


    public BaseException(ResultCodeBase resultCodeBase, Map<String, ?> errors) {
        super(resultCodeBase.getMsg());
        this.resultCodeBase = resultCodeBase;
        this.errors = errors;
    }
}
