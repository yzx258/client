package com.rbgt.client.controller;

/**
 * @project_name: client
 * @package_name: com.rbgt.client.controller
 * @name: LogTestController
 * @author: Administrator
 * @date: 2020/1/28
 * @time: 16:52
 * @day_name_full: 星期二
 **/
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Baron
 * @Description: 日志输出配置demo
 * @Date: Created in 2019/3/26 17:46
 */
@RestController
@RequestMapping("/log")
@Slf4j
public class LogTestController {

    @RequestMapping("/debug")
    public String printDebug() {

        String msg = "this is a debug msg !";
        log.debug(msg);
        return msg;
    }

    @RequestMapping("/info")
    public String printInfo() {

        String msg = "this is a info msg !";
        log.info(msg);
        return msg;
    }

    @RequestMapping("/warn")
    public String printWarn() {

        String msg = "this is a warn msg !";
        log.warn(msg);
        return msg;
    }

    @RequestMapping("/error")
    public String printError() {

        String msg = "this is a error msg !";
        log.error(msg);
        return msg;
    }

}
