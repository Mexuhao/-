package com.example;

import com.example.mapper.DepartmentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class YebApplicationTests {
    @Autowired


    private DepartmentMapper dm;


    @Test
    void contextLoads() {


        System.out.println(dm.selectById(1));
    }

}
