package com.rbgt.client.controller;

import com.rbgt.client.data.BaseResponse;
import com.rbgt.client.data.ResponseCode;
import com.rbgt.client.entity.School;
import com.rbgt.client.exception.BaseException;
import com.rbgt.client.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @project_name: client
 * @package_name: com.rbgt.client.controller
 * @name: UserController
 * @author: Administrator
 * @date: 2020/1/27
 * @time: 16:42
 * @day_name_full: 星期一
 **/
@RestController
@Api(value = "用户服务")
@Slf4j
@BaseResponse
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "查询用户所有信息",notes = "携带的参数必填",httpMethod = "GET")
    @ApiImplicitParam(dataType = "string",name = "name",value = "姓名",required = true)
    @GetMapping("/list")
    public Object findAll(String name) {
        System.out.println("name:"+name);
        List<School> list = userService.findAll();
        return list;
    }

    private String msg = "ok";
    @RequestMapping("/hello")
    public String hello() {
        String[] arr = new String[2];
        arr[0] = "213";
        arr[1] = "213";
        arr[2] = "213";
        arr[3] = "213";
        return "ok";
    }

    @RequestMapping("/hellos")
    public void hellos() {
        int num = 1/0;
        //throw new BusinessException("100","密码错误");
        //return this.msg;
    }

    @GetMapping("/{userId}")
    public Object getUserById(@PathVariable Integer userId){
        if(userId.equals(0)){
            throw new BaseException(ResponseCode.RESOURCES_NOT_EXIST);
        }
        if(userId.equals(1)){
            throw new RuntimeException();
        }

        return userId;
    }
}
