package com.cmr.datasource.entity.resp;

import com.cmr.datasource.constants.ResponseCode;
import lombok.Data;

import java.io.Serializable;

/**
 * @author chenmengrui
 * @Description: 响应
 * @date 2019/11/11 11:48
 */
@Data
public class Response<T> implements Serializable {

    private int code;

    private String msg;

    private T data;

    public Response(ResponseCode responseCode, T data) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMessage();
        this.data = data;
    }

    public Response(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
