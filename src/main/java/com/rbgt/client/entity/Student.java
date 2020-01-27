package com.rbgt.client.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * @project_name: client
 * @package_name: com.rbgt.client.entity
 * @name: Student
 * @author: Administrator
 * @date: 2020/1/27
 * @time: 16:51
 * @day_name_full: 星期一
 **/
@Getter
@Setter
@ToString
@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "sch_id")
    private String schId;

    @Column(name = "sch_name")
    private String schName;

    @Column(name = "age")
    private String age;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;
}
