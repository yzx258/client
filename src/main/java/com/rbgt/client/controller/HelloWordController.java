package com.rbgt.client.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbgt.client.constans.eunms.BusinessDept;
import com.rbgt.client.entity.UserEntity;
import com.rbgt.client.util.EnumUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author yucw
 * @date 2020/3/25 14:18
 */
@RestController
public class HelloWordController {

    @RequestMapping("/helloEunms")
    public String getHelloWord() throws JsonProcessingException {
        UserEntity u = new UserEntity();
        u.setServiceProviderId("444");
        System.out.println(new ObjectMapper().writeValueAsString(BusinessDept.class.getEnumConstants()));
        return new ObjectMapper().writeValueAsString(u);
    }

    @RequestMapping("/eunms")
    public Map<String, Object[]> getEunms() throws JsonProcessingException {
        Map<String, Object[]> _enum2 = EnumUtils.getEnumPackageEnums(BusinessDept.class);
        return _enum2;
    }

}
