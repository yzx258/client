package com.rbgt.client.dao;

import com.rbgt.client.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @project_name: client
 * @package_name: com.rbgt.client.dao
 * @name: UserDao
 * @author: Administrator
 * @date: 2020/1/27
 * @time: 16:19
 * @day_name_full: 星期一
 **/
@Component
public interface SchoolDao extends JpaRepository<School, Long> {

}
