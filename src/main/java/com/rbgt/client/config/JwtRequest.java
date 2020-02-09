package com.rbgt.client.config;

/**
 * @project_name: spring-boot-security
 * @package_name: security01.config
 * @name: JwtRequest
 * @author: 俞春旺
 * @date: 2020/2/9 11:44
 * @day_name_full: 星期日
 * @remark: 无
 **/
import java.io.Serializable;

public class JwtRequest implements Serializable {

    private static final long serialVersionUID = 5926468583005150707L;

    private String username;
    private String password;

    //need default constructor for JSON Parsing
    public JwtRequest()
    {

    }

    public JwtRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
