package com.rbgt.client.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @project_name: client
 * @package_name: com.rbgt.client.entity
 * @name: User
 * @author: Administrator
 * @date: 2020/1/27
 * @time: 16:18
 * @day_name_full: 星期一
 **/
@Getter
@Setter
@ToString
@Data
@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id ;

    @Column(name = "name",length = 32)
    private String name ;

    @Column(name = "address",length = 32)
    private String address;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "sch_id")
    private List<Student> students;

    @NotNull(message = "comment is not null")
    private String comment;
}
