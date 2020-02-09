package com.rbgt.client.config;

/**
 * @project_name: spring-boot-security
 * @package_name: security01.config
 * @name: JwtResponse
 * @author: 俞春旺
 * @date: 2020/2/9 11:45
 * @day_name_full: 星期日
 * @remark: 无
 **/
import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    public JwtResponse(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }
}
