package com.rbgt.client.service;

import com.rbgt.client.entity.School;

import java.util.List;

/**
 * @project_name: client
 * @package_name: com.rbgt.client.service
 * @name: UserService
 * @author: Administrator
 * @date: 2020/1/27
 * @time: 16:27
 * @day_name_full: 星期一
 **/
public interface UserService {
    /**
     * 查询全部User信息
     * @return List<User>
     */
    List<School> findAll();
}
