package com.rbgt.client.mapper;

import com.rbgt.client.entity.School;
import com.rbgt.client.entity.SchoolDTO;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.SelectProvider;
import java.util.List;

/**
 * @project_name: client
 * @package_name: com.rbgt.client.mapper
 * @name: ShoolMapper
 * @author: 俞春旺
 * @date: 2020/3/25 21:02
 * @day_name_full: 星期三
 * @remark: 无
 **/
@Repository
@Mapper
public interface ShoolMapper {

    @SelectProvider(type = School.class, method = "getAll")
    @Results({
            @Result(column = "dcc_call_status", property = "dccCallStatus"),
    })
    List<SchoolDTO> getClueDtos();

}
