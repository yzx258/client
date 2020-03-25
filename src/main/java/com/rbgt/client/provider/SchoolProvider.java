package com.rbgt.client.provider;

import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * @project_name: client
 * @package_name: com.rbgt.client.provider
 * @name: SchoolProvider
 * @author: 俞春旺
 * @date: 2020/3/25 21:08
 * @day_name_full: 星期三
 * @remark: 无
 **/
@Slf4j
public class SchoolProvider implements Serializable {

    public String getAll()
    {
        return "select * from school";
    }

}
