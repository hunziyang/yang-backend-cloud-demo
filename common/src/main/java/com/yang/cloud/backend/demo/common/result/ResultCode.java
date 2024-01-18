package com.yang.cloud.backend.demo.common.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode implements ResultCodeBase {
    SUCCESS(200, "Success"),
    BAD_REQUEST(400, "Bad Request"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    FEIGN_ERROR(600, "Feign 调用异常"),
    FLOW_ERROR(601, "流量限流"),
    DEGRADE_ERROR(602, "服务降级"),
    SENTINEL_ERROR(603, "sentinel 降级");

    private Integer code;
    private String msg;
}
