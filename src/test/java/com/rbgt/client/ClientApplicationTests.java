package com.rbgt.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rbgt.client.entity.School;
import com.rbgt.client.entity.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ClientApplicationTests {

    @Autowired
    private com.rbgt.client.dao.SchoolDao SchoolDao;

    @Test
    void contextLoads() {
        School entity = new School();
        entity.setName("a学校");
        entity.setAddress("龙场");
        Student stu1 = new Student();
        stu1.setName("小明ssss");
        stu1.setAge("123sss");
        Student stu2 = new Student();
        stu2.setName("小华ssssss");
        stu2.setAge("13sss");
        List<Student> list = new ArrayList<Student>();
        list.add(stu1);
        list.add(stu2);
        entity.setStudents(list);
        SchoolDao.saveAndFlush(entity);
    }

    public static void main(String[] args) throws IOException {
        School entity = new School();
        entity.setName("a学校");
        entity.setAddress("龙场");

        ObjectMapper json = new ObjectMapper();
        String s = json.writeValueAsString(entity);
        System.out.println("我是jackson转换的对象：" + s);

        School school = json.readValue(s, School.class);
        System.out.println(school);
    }
}
