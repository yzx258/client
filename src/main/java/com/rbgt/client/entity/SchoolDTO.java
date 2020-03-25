package com.rbgt.client.entity;

import java.io.Serializable;

/**
 * @project_name: client
 * @package_name: com.rbgt.client.entity
 * @name: SchoolDTO
 * @author: 俞春旺
 * @date: 2020/2/28 9:57
 * @day_name_full: 星期五
 * @remark: 无
 **/
public class SchoolDTO implements Serializable {

    private String name ;

    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SchoolDTO(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
