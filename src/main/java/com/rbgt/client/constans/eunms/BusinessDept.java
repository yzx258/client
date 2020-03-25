package com.rbgt.client.constans.eunms;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author WangXiao
 * @title: BusinessDept
 * @projectName yiautos-sales-service
 * @description: //TODO ${END}
 * @date 2019/5/1416:53
 */
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BusinessDept {

    DEPT_STORE(1, "门店"),
    DEPT_CHANNEL(2, "渠道"),
    DEPT_BIG_CUSTOMER(3, "大客户部")
    ;

    private int code;
    private String name;
}
