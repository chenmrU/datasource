package com.cmr.datasource.exception;

import com.cmr.datasource.constants.ResponseCode;
import lombok.Data;

/**
 * @author chenmengrui
 * @Description: 业务异常
 * @date 2019/11/15 18:57
 */
@Data
public class BizException extends RuntimeException {

    private ResponseCode responseCode;
    private String message;

    public BizException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.responseCode = responseCode;
    }

    public BizException(ResponseCode responseCode, String message) {
        this(responseCode);
        this.message = message;
    }

    public BizException(ResponseCode responseCode, Throwable throwable) {
        super(responseCode.getMessage(), throwable);
        this.responseCode = responseCode;
    }

    public BizException(ResponseCode responseCode, Throwable throwable, String message) {
        this(responseCode, throwable);
        this.message = message;
    }

    public static void throwout(ResponseCode responseCode) {
        throw new BizException(responseCode);
    }

}
