package com.rbgt.client.data;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @project_name: client
 * @package_name: com.rbgt.client.data
 * @name: ResponseCode
 * @author: Administrator
 * @date: 2020/1/27
 * @time: 19:03
 * @day_name_full: 星期一
 **/
public enum ResponseCode {
    /**
     * 成功返回的状态码
     */
    SUCCESS(10000, "success"),
    /**
     * 资源不存在的状态码
     */
    RESOURCES_NOT_EXIST(10001, "资源不存在"),
    /**
     * 所有无法识别的异常默认的返回状态码
     */
    SERVICE_ERROR(50000, "服务器异常"),
    /**
     * 所有无权限的返回状态码
     */
    NOT_PERMISSION(10002,"无访问权限");
    /**
     * 状态码
     */
    private int code;
    /**
     * 返回信息
     */
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
