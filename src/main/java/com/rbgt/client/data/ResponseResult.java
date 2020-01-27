package com.rbgt.client.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @project_name: client
 * @package_name: com.rbgt.client.data
 * @name: ResponseResult
 * @author: Administrator
 * @date: 2020/1/27
 * @time: 19:01
 * @day_name_full: 星期一
 **/
@Data
@AllArgsConstructor
public class ResponseResult implements Serializable {
    /**
     * 返回状态码
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 数据
     */
    private Object data;

}
