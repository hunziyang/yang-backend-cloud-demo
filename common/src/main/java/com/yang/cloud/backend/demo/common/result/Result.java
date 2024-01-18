package com.yang.cloud.backend.demo.common.result;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Map;

@Data
@Accessors(chain = true)
public class Result<T> {

    private Integer code;
    private String msg;
    private T body;
    private Map<String, ?> errors;

    public static Result success() {
        return new Result().setCode(ResultCode.SUCCESS.getCode()).setMsg(ResultCode.SUCCESS.getMsg());
    }

    public static <E> Result success(E body) {
        return new Result<E>().setCode(ResultCode.SUCCESS.getCode()).setMsg(ResultCode.SUCCESS.getMsg()).setBody(body);
    }

    public static Result error(ResultCodeBase resultCodeBase) {
        return new Result().setCode(resultCodeBase.getCode()).setMsg(resultCodeBase.getMsg());
    }

    public static Result error(ResultCodeBase resultCodeBase, Map<String, ?> errors) {
        return new Result().setCode(resultCodeBase.getCode()).setMsg(resultCodeBase.getMsg()).setErrors(errors);
    }
}
