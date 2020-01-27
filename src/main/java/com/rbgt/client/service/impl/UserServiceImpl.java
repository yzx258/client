package com.rbgt.client.service.impl;

import com.rbgt.client.dao.SchoolDao;
import com.rbgt.client.entity.School;
import com.rbgt.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @project_name: client
 * @package_name: com.rbgt.client.service.impl
 * @name: UserServiceImpl
 * @author: Administrator
 * @date: 2020/1/27
 * @time: 16:29
 * @day_name_full: 星期一
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SchoolDao userDao;

    @Override
    public List<School> findAll() {
        return userDao.findAll();
    }
}
