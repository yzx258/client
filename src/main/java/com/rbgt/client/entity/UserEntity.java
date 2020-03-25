package com.rbgt.client.entity;

import com.rbgt.client.constans.eunms.BusinessDept;
import lombok.*;

/**
 * @author yucw
 * @date 2020/3/25 14:44
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class UserEntity {

   private String serviceProviderId;

   private BusinessDept bd = BusinessDept.DEPT_BIG_CUSTOMER;

}
