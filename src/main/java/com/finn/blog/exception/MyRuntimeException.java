package com.finn.blog.exception;

import com.finn.blog.enums.StatusCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.finn.blog.enums.StatusCodeEnum.FAIL;

/*
 * @description: 我的运行时异常
 * @author: Finn
 * @create: 2022/04/03 18:12
 */
@Getter
@AllArgsConstructor
public class MyRuntimeException extends RuntimeException {
    /**
     * 错误码
     */
    private Integer code = FAIL.getCode();

    /**
     * 错误信息
     */
    private final String message;

    public MyRuntimeException(String message) {
        this.message = message;
    }

    public MyRuntimeException(StatusCodeEnum statusCodeEnum) {
        this.code = statusCodeEnum.getCode();
        this.message = statusCodeEnum.getDesc();
    }

}
