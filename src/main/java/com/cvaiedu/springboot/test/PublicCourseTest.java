package com.cvaiedu.springboot.test;

import com.cvaiedu.springboot.business.entity.PublicCourse;
import com.cvaiedu.springboot.business.service.inter.PublicCourseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PublicCourseTest {

    @Autowired
    PublicCourseService publicCourseService;

    @Test
    public void listTest() {
        List<PublicCourse> list = publicCourseService.list(new HashMap<>());
        for (PublicCourse publicCourse : list) {
            System.out.println(publicCourse.toString());
        }
    }
}
